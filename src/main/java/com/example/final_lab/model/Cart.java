package com.example.final_lab.model;

import com.example.final_lab.model.abstracts.AbstractEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Builder
public class Cart extends AbstractEntity {
    @Id
    @GeneratedValue(generator = "attendance_id_seq")
    @SequenceGenerator(name = "attendance_id_seq", sequenceName = "attendance_id_seq", allocationSize = 1)
    private Long id;

    private Long totalCost;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Product> products;

    Cart() {
        totalCost = 0L;
    }
}
