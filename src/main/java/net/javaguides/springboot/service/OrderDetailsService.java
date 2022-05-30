package net.javaguides.springboot.service;

import net.javaguides.springboot.model.Item;
import net.javaguides.springboot.model.OrderDetails;
import net.javaguides.springboot.model.User;

public interface OrderDetailsService {

    OrderDetails addItemToOrder(Item item, User user);


}
