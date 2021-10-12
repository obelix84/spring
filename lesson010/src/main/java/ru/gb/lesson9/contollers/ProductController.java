package ru.gb.lesson9.contollers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.lesson9.domains.Product;
import ru.gb.lesson9.repository.ProductRepository;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public ResponseEntity<List<Product>>findAll(){
        List<Product> products = new ArrayList<>();
        productRepository.findAll().forEach(products::add);
        return ResponseEntity.ok(products);
    }

    @GetMapping
    @RequestMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable long id){
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(productOptional.get());
    }

    @PostMapping
    public ResponseEntity<Product> save(@RequestBody Product product) {
        Product newCreatedProduct = productRepository.save(product);
        return ResponseEntity.created(URI.create("/products/" + newCreatedProduct.getId())).body(newCreatedProduct);
    }

    @DeleteMapping("/{id}")
    public int deleteProduct(@PathVariable Long id) {
        productRepository.deleteById(id);
        return HttpStatus.OK.value();
    }

    @ExceptionHandler
    public ResponseEntity<ProductError> handleException(RuntimeException ex) {
        return ResponseEntity.internalServerError()
                .body(new ProductError(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage()));
    }

}
