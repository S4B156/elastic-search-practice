package com.sia.elastic_search_practice.controllers;

import com.sia.elastic_search_practice.dto.ItemRequest;
import com.sia.elastic_search_practice.entity.ItemDoc;
import com.sia.elastic_search_practice.repository.ItemElasticsearchRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/add")
@Slf4j
public class AddItemController {
    @Autowired
    private ItemElasticsearchRepository itemElasticsearchRepository;

    @PostMapping
    public String addItem(ItemRequest itemRequest){
        ItemDoc itemDoc = new ItemDoc(itemRequest.getItemName(), itemRequest.getDescription(), itemRequest.getPlace());
        log.info("add new item {}", itemDoc);
        itemElasticsearchRepository.save(itemDoc);
        return "redirect:/add";
    }

    @GetMapping
    public String addItemPage(){
        return "addItem";
    }
}
