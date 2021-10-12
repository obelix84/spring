package ru.gb.web;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.gb.entity.Cart;
import ru.gb.entity.Category;
import ru.gb.entity.Product;
import ru.gb.repository.CartRepository;
import ru.gb.repository.CategoryRepository;
import ru.gb.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {

    private final CartRepository cartRepository;
    private final ProductRepository prodRepository;

    public CartController(CartRepository cartRepo, ProductRepository prodRepo) {
        this.cartRepository = cartRepo;
        this.prodRepository = prodRepo;
    }

    @GetMapping
    public String findAll(Model model) {
        //упрощаем, без пользователя, считаем, что всем показывается первая корзина
        model.addAttribute("cart", cartRepository.findById(1L).get());
        return "cart/cart-all";
    }

    @GetMapping("/add/{productId}")
    public String addToCart(@PathVariable long productId) {
        System.out.println("gfhfhf");
        Cart cart = this.cartRepository.findById(1L).get();
        List<Product> prod = cart.getProducts();
        prod.add(this.prodRepository.findById(productId).get());
        cart.setProducts(prod);
        this.cartRepository.save(cart);
        return "redirect:/cart";
    }
}
