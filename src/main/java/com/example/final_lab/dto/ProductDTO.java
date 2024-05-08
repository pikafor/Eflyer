package com.example.final_lab.dto;

import com.example.final_lab.enums.Availability;
import com.example.final_lab.enums.ProductType;
import com.example.final_lab.dto.abstracts.AbstractDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = false)
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO extends AbstractDTO {
    private Long id;

    private String name;

    private Long price;

    private String img;

    private ProductType type;

    public String toString() {
        return name + ' ' + price + ' ' + type.label;
    }
}
