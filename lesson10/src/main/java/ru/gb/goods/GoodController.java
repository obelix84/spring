package ru.gb.goods;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/goods/mvc")
public class GoodController {
    private final GoodRepository repository;

    public GoodController(GoodRepository repository) {
        this.repository = repository;
    }


    @GetMapping
    public String getAllGoods(Model model) {
        List<Good> goods = new ArrayList<>();
        repository.findAll().forEach(goods::add);
        model.addAttribute("goods", goods);
        return "goods-all";
    }

    @Secured({"ADMIN", "MANAGER"})
    @GetMapping("/edit")
    public String getGoodsEditForm(Model model) {
        List<Good> goods = new ArrayList<>();
        repository.findAll().forEach(goods::add);
        model.addAttribute("goods", goods);
        Good saveGood = new Good();
        model.addAttribute("good", saveGood);
        return "goods-edit";
    }

    @Secured({"ADMIN", "MANAGER"})
    @PostMapping("/edit")
    public String save(Good good, BindingResult result) {
        if (result.hasErrors()) {
            return "goods-edit";
        }
        repository.save(good);
        return "redirect:/goods/mvc/edit";
    }

}
