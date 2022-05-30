package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.OrderDetails;
import net.javaguides.springboot.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Long> {

    List<OrderDetails> findByOrders(Orders orders);
}