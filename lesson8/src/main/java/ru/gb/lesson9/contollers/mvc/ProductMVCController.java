package ru.gb.lesson9.contollers.mvc;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.gb.lesson9.domains.Product;
import ru.gb.lesson9.repository.ProductRepository;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/products/mvc")
public class ProductMVCController {
    private final ProductRepository repository;

    public ProductMVCController(ProductRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public String findAllPaginated(Model model, @RequestParam("page") Optional<Integer> page,
                                   @RequestParam("size") Optional<Integer> size) {
        long countOfProducts = repository.count();
        //тут я привел к int, но это не очень хорошо...
        int pageSize = size.orElse((int) (countOfProducts / 2));
        Pageable pageable = PageRequest.of(page.orElse(0), pageSize);
        List<Product> products = new ArrayList<>();
        repository.findAll(pageable).forEach(products::add);
        model.addAttribute("products", products);
        //формируем pagination
        int totalPages = (int) countOfProducts / pageSize;
        int lastPage = (countOfProducts % pageSize) == 0? 0: 1;
        model.addAttribute("totalPages", totalPages - lastPage);
        model.addAttribute("pageSize", pageSize);
        if (totalPages >= 1) {
            List<Integer> pageNumbers = IntStream.rangeClosed(0, totalPages + lastPage - 1)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        return "products";
    }

    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable long id) {
        repository.deleteById(id);
        return "redirect:/products/mvc";
    }

    @GetMapping("/form")
    public String saveForm(Product product) {
        return "product-add";
    }


    @PostMapping
    public String save(@Valid Product product, BindingResult result) {
        if (result.hasErrors()) {
            return "product-add";
        }
        repository.save(product);
        return "redirect:/products/mvc";
    }

    //очень упрощенно, но пусть бужет
    @ExceptionHandler
    public String handleException(RuntimeException ex) {
        return "product-err";
    }

}