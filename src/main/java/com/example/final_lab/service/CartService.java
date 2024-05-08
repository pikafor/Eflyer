package com.example.final_lab.service;

import com.example.final_lab.dto.CartDTO;
import com.example.final_lab.dto.ProductDTO;

public interface CartService {
    CartDTO save(CartDTO cart);

    CartDTO getById(Long id);

    CartDTO addProduct(Long CartId, Long ProductId);

    void delete(CartDTO cartDTO);

    void deleteProduct(Long CartId, Long ProductId);
}
