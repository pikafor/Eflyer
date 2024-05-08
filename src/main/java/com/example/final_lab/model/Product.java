package com.example.final_lab.model;

import com.example.final_lab.enums.Availability;
import com.example.final_lab.enums.ProductType;
import com.example.final_lab.model.abstracts.AbstractEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product extends AbstractEntity {
    @Id
    @GeneratedValue(generator = "attendance_id_seq")
    @SequenceGenerator(name = "attendance_id_seq", sequenceName = "attendance_id_seq", allocationSize = 1)
    private Long id;

    private String name;

    private Long price;

    private String img;

    @Enumerated(EnumType.STRING)
    private ProductType type;

    public String toString() {
        return id +  ' ' + name +  ' ' + price + ' ' + type.label;
    }
}
