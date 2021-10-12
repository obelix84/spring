package ru.gb.lesson9.contollers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.lesson9.domains.Cart;
import ru.gb.lesson9.domains.Product;
import ru.gb.lesson9.repository.CartRepository;
import ru.gb.lesson9.repository.ProductRepository;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/cart")
public class CartController {

    private final CartRepository cartRepo;
    private final ProductRepository prodRepo;

    public CartController(CartRepository cartRepo, ProductRepository prodRepo) {
        this.cartRepo = cartRepo;
        this.prodRepo = prodRepo;
    }

    @GetMapping
    //возвращает корзину пользователя
    public ResponseEntity<Cart> getCart(){
        //считаем, что у нас одна корзина с номером 1, для текущего пользователя.
        Optional cartOptional = cartRepo.findById(1L);
        if (cartOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok((Cart) cartOptional.get());
    }

    @PostMapping("add/{id}")
    //добавляет в корзину продукт
    public ResponseEntity<Cart> addToCart(@PathVariable Long id){
        Optional<Cart> cartOptional = cartRepo.findById(1L);
        Optional<Product> productOptional = prodRepo.findById(id);
        if (productOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Product prod = productOptional.get();
        if (cartOptional.isEmpty()) {
            //если корзины такой нет, то надо ее создать
            ArrayList<Product> products = new ArrayList<Product>();
            products.add(prod);
            Cart cart = new Cart(1L, 1, products);
            cartRepo.save(cart);
            return ResponseEntity.ok(cart);
        }
        cartOptional.get().getProducts().add(prod);
        cartRepo.save(cartOptional.get());
        return ResponseEntity.ok(cartOptional.get());
    }

    @DeleteMapping("remove/{id}")
    public int deleteStudent(@PathVariable Long id) {
        Optional<Cart> cartOptional = cartRepo.findById(1L);
        cartOptional.get().getProducts().remove(prodRepo.findById(id).get());
        cartRepo.save(cartOptional.get());
        return HttpStatus.OK.value();
    }


}
