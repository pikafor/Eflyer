package com.example.final_lab.service;

import com.example.final_lab.dto.ProductDTO;
import com.example.final_lab.enums.Availability;
import com.example.final_lab.enums.ProductType;

import java.util.List;

public interface ProductService {
    ProductDTO save(ProductDTO product, String img, ProductType type);

    List<ProductDTO> getAll();

    void delete(Long productId);
}
