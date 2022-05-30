package net.javaguides.springboot.web;

import net.javaguides.springboot.model.Item;
import net.javaguides.springboot.model.OrderDetails;
import net.javaguides.springboot.model.User;
import net.javaguides.springboot.service.ItemService;
import net.javaguides.springboot.service.OrderDetailsService;
import net.javaguides.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

public class ShoppingCartController {

    @Autowired
    private UserService userService;

    @Autowired
    private OrderDetailsService orderDetailsService;

    @Autowired
    ItemService itemService;

    @RequestMapping("/addItem")
    public String addItem(@ModelAttribute("item") Item item,
                          Model model, Principal principal
    ) {
        User user = userService.findByUserId(Long.valueOf(principal.getName())); //This might not work
        item = itemService.findByItemId(item.getItemId());

        OrderDetails orderDetails = orderDetailsService.
                addItemToOrder(item, user);
        model.addAttribute("itemAdded", true);

        return "menu";
    }
}
