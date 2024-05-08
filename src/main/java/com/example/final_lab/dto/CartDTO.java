package com.example.final_lab.dto;

import com.example.final_lab.dto.abstracts.AbstractDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@SuperBuilder
@AllArgsConstructor
public class CartDTO extends AbstractDTO {
    private Long id;

    private Long totalCost;

    private List<ProductDTO> products;

    CartDTO() {
        totalCost = 0L;
    }
}
