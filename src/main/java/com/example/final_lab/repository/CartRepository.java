package com.example.final_lab.repository;

import com.example.final_lab.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository  extends JpaRepository<Cart, Long> {
}
