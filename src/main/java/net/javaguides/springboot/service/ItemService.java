package net.javaguides.springboot.service;

import net.javaguides.springboot.model.Item;

public interface ItemService {
    Item findByItemId(Long id);
}
