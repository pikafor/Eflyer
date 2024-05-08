package com.example.final_lab.service.impl;

import com.example.final_lab.dto.CartDTO;
import com.example.final_lab.dto.ProductDTO;
import com.example.final_lab.mapper.CartMapper;
import com.example.final_lab.mapper.ProductMapper;
import com.example.final_lab.model.Cart;
import com.example.final_lab.model.Product;
import com.example.final_lab.repository.CartRepository;
import com.example.final_lab.repository.ProductRepository;
import com.example.final_lab.service.CartService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CartServiceImpl implements CartService {
    private final CartRepository repository;
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final CartMapper mapper;

    @Override
    public CartDTO save(CartDTO cart) {
        return mapper.toDto(repository.save(mapper.toEntity(cart)));
    }

    @Override
    public CartDTO getById(Long id) {
        return mapper.toDto(repository.getById(id));
    }

    @Override
    public CartDTO addProduct(Long CartId, Long productId) {
        Cart cart = repository.getById(CartId);

        Long totalCost = cart.getTotalCost();
        cart.setTotalCost(totalCost += (Long)productRepository.getById(productId).getPrice());
        cart.getProducts().add(productRepository.getById(productId));
        return mapper.toDto(repository.save(cart));
    }

    @Override
    public void delete(CartDTO cartDTO) {
        repository.delete(mapper.toEntity(cartDTO));
    }

    @Override
    public void deleteProduct(Long cartId, Long productId) {
        Cart cart = repository.getById(cartId);

        cart.setTotalCost(cart.getTotalCost()
                - productRepository.getById(productId).getPrice());

        for (int i = 0; i < cart.getProducts().size(); i++) {
            Product product = cart.getProducts().get(i);
            if (product.getId() == productId) {
                cart.getProducts().remove(i);
            }
            repository.save(cart);
        }
    }
}
