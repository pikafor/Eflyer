package com.example.final_lab.mapper;

import com.example.final_lab.dto.CartDTO;
import com.example.final_lab.model.Cart;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CartMapper extends AbstractMapper<Cart, CartDTO>{
    @Autowired
    private ProductMapper productMapper;

    void mapSpecificFields(CartDTO source, Cart destination) {
        destination.setProducts(source.getProducts().stream().map(productMapper::toEntity).toList());
    }

    void mapSpecificFields(Cart source, CartDTO destination) {
        destination.setProducts(source.getProducts().stream().map(productMapper::toDto).toList());
    }

    CartMapper(ModelMapper mapper) {
        super(Cart.class, CartDTO.class);
        this.mapper = mapper;
    }

    @Override
    public void configureMapper() {
        mapper.createTypeMap(Cart.class, CartDTO.class)
                .setPostConverter(toDtoConverter());
        mapper.createTypeMap(CartDTO.class, Cart.class, "toNew")
                .setPostConverter(toEntityConverter());
        mapper.createTypeMap(CartDTO.class, Cart.class, "toUpdate")
                .setPostConverter(toEntityConverter());
    }

    public Cart toEntity(CartDTO source) {
        return getNewEntity(source);
    }

    private Cart getNewEntity(CartDTO source) {
        return mapper.map(source, Cart.class, "toNew");
    }
}
