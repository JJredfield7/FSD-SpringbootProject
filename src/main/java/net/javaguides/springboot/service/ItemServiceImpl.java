package net.javaguides.springboot.service;

import net.javaguides.springboot.model.Item;
import net.javaguides.springboot.repository.ItemRepository;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl {

    private ItemRepository itemRepository;

    public Item findByItemId(Long id){
        return itemRepository.findById(id).orElse(null);
    }
}
