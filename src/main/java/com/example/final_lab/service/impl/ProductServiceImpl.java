package com.example.final_lab.service.impl;

import com.example.final_lab.dto.ProductDTO;
import com.example.final_lab.enums.Availability;
import com.example.final_lab.enums.ProductType;
import com.example.final_lab.mapper.ProductMapper;
import com.example.final_lab.repository.ProductRepository;
import com.example.final_lab.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.data.util.TypeUtils.type;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper mapper;

    @Override
    public ProductDTO save(ProductDTO product, String img, ProductType type) {
        product.setImg(img);
        product.setType(type);
        return mapper.toDto(productRepository.save(mapper.toEntity(product)));
    }

    @Override
    public List<ProductDTO> getAll() {
        return productRepository.findAll().stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public void delete(Long productId) {
        productRepository.delete(productRepository.getById(productId));
    }
}
