package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders, Long> {
}