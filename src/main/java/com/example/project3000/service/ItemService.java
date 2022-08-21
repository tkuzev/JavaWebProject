package com.example.project3000.service;

import com.example.project3000.model.Item;
import com.example.project3000.model.User;
import com.example.project3000.model.dto.ItemAddDTO;
import com.example.project3000.repository.ItemRepository;
import com.example.project3000.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
public class ItemService {
    private ItemRepository itemRepository;
    private UsersRepository usersRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository, UsersRepository usersRepository) {
        this.itemRepository = itemRepository;
        this.usersRepository=usersRepository;
    }

    public void add(ItemAddDTO itemAddDTO) {
        Item item=new Item(
                itemAddDTO.getDescription(),
                itemAddDTO.getName(),
                itemAddDTO.getSeller(),
                itemAddDTO.getCategory()
        );

        this.itemRepository.save(item);
    }

}
