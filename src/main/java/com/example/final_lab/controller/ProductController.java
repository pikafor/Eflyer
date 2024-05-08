package com.example.final_lab.controller;

import com.example.final_lab.dto.ProductDTO;
import com.example.final_lab.enums.Availability;
import com.example.final_lab.enums.ProductType;
import com.example.final_lab.service.ProductService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
@Tag(name = "product", description = "The main API for employees in system, used JWT to check permissions")
public class ProductController {
    private final ProductService productService;

    @PostMapping
    ResponseEntity<ProductDTO> save(@RequestBody ProductDTO product, @RequestParam @NotNull String img, @RequestParam @NotNull ProductType type) {
        return new ResponseEntity<>(productService.save(product, img, type), HttpStatus.OK);
    }

    @GetMapping
    ResponseEntity<List<ProductDTO>> getAll() {
        return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
    }
}
