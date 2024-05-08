package com.example.final_lab.controller;

import com.example.final_lab.dto.CartDTO;
import com.example.final_lab.service.CartService;
import com.example.final_lab.service.ProductService;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class GreetingController {
    private final ProductService productService;
    private final CartService cartService;

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="source", required=false, defaultValue="Ivan") String name, Model model) {
        model.addAttribute("source", productService.getAll());

        return "index";
    }
    @GetMapping("catalog")
    public String catalog(@RequestParam(name="source", required=false, defaultValue="Ivan") String name, Model model) {
        model.addAttribute("source", productService.getAll());
        return "products";
    }
    @GetMapping("cart")
    public String cart(@RequestParam(name="source", required=false, defaultValue="Ivan") String name, Model model) {
        model.addAttribute("cart", cartService.getById(31L));
        return "cart";
    }
    @GetMapping("reviews")
    public String reviews(@RequestParam(name="source", required=false, defaultValue="Ivan") String name, Model model) {
        model.addAttribute("source", productService.getAll());
        return "reviews";
    }
    @GetMapping("login")
    public String login(@RequestParam(name="source", required=false, defaultValue="Ivan") String name, Model model) {
        model.addAttribute("source", productService.getAll());
        return "Unti";
    }
    @PostMapping("/addProduct")
    public String addProduct(@RequestParam @NotNull Long cartId, @RequestParam @NotNull Long productId) {
        cartService.addProduct(cartId, productId);
        return "redirect:/greeting";
    }
    @PostMapping("/deleteProduct")
    public String delProduct(@RequestParam @NotNull Long cartId, @RequestParam @NotNull Long productId) {
        cartService.deleteProduct(cartId, productId);
        return "redirect:/cart";
    }
}