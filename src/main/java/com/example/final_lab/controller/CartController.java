package com.example.final_lab.controller;

import com.example.final_lab.dto.CartDTO;
import com.example.final_lab.dto.ProductDTO;
import com.example.final_lab.model.Cart;
import com.example.final_lab.service.CartService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carts")
@RequiredArgsConstructor
@Tag(name = "cart", description = "The main API for employees in system, used JWT to check permissions")
public class CartController {
    private final CartService service;

    @PostMapping("/save")
    ResponseEntity<CartDTO> save(@RequestBody CartDTO cartDTO) {
        return new ResponseEntity<>(service.save(cartDTO), HttpStatus.OK);
    }

    @GetMapping("/get")
    ResponseEntity<CartDTO> getById(@RequestParam @NotNull Long id) {
        return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
    }

    @PostMapping("/addProduct")
    ResponseEntity<CartDTO> addProduct(@RequestParam @NotNull Long cartId, @RequestParam @NotNull Long productId) {
        return new ResponseEntity<>(service.addProduct(cartId, productId), HttpStatus.OK);
    }
}
