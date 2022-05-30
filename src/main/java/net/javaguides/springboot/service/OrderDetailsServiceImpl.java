package net.javaguides.springboot.service;

import net.javaguides.springboot.model.Item;
import net.javaguides.springboot.model.OrderDetails;
import net.javaguides.springboot.model.Orders;
import net.javaguides.springboot.model.User;
import net.javaguides.springboot.repository.OrderDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderDetailsServiceImpl {

    @Autowired
    OrderDetailsRepository orderDetailsRepository;

    public OrderDetails addItemtoOrder(Item item, User user){
        List<OrderDetails> orderDetailsList = findByUserOrders(user.getOrders());

        for(OrderDetails orderDetails : orderDetailsList){
            if(item.getItemId() == orderDetails.getItem().getItemId()){
                //Check to see if this works properly
                Orders orders = new Orders();
                orders.setOrderTotal(item.getItem_price());
                orderDetailsRepository.save(orderDetails);
                return orderDetails;
            }
        }

        OrderDetails orderDetails = new OrderDetails();
        orderDetails.setOrders(user.getOrders());
        orderDetails.setItem(item);
        orderDetails = orderDetailsRepository.save(orderDetails);

        return orderDetails;
    }

    public List<OrderDetails> findByUserOrders(Orders orders){
        return orderDetailsRepository.findByOrders(orders);
    }


}
