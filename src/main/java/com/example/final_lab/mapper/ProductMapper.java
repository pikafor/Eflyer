package com.example.final_lab.mapper;

import com.example.final_lab.dto.ProductDTO;
import com.example.final_lab.model.Product;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper extends AbstractMapper<Product, ProductDTO>{
    ProductMapper(ModelMapper mapper) {
        super(Product.class, ProductDTO.class);
        this.mapper = mapper;
    }

    @Override
    public void configureMapper() {
        mapper.createTypeMap(Product.class, ProductDTO.class)
                .setPostConverter(toDtoConverter());
        mapper.createTypeMap(ProductDTO.class, Product.class, "toNew")
                .setPostConverter(toEntityConverter());
        mapper.createTypeMap(ProductDTO.class, Product.class, "toUpdate")
                .setPostConverter(toEntityConverter());
    }

    public Product toEntity(ProductDTO source) {
        return getNewEntity(source);
    }

    private Product getNewEntity(ProductDTO source) {
        return mapper.map(source, Product.class, "toNew");
    }
}
