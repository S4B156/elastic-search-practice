package com.sia.elastic_search_practice.controllers;

import com.sia.elastic_search_practice.entity.ItemDoc;
import com.sia.elastic_search_practice.repository.ItemElasticsearchRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
public class HomeController {
    @Autowired
    private ItemElasticsearchRepository itemElasticsearchRepository;

    @GetMapping("/")
    public String homePage(){
        return "index";
    }
    @GetMapping("/search")
    public String search(@RequestParam("query") String query,
                         @RequestParam(name = "page", defaultValue = "0") int page,
                         @RequestParam(name = "size", defaultValue = "10") int size,
                         Model model){
        log.info("in search");
        Pageable pageable = PageRequest.of(page, size);
        Page<ItemDoc> itemDocs = itemElasticsearchRepository.searchByQuery(query, pageable);
        for(ItemDoc page1 : itemDocs){
            log.info(itemDocs.toString());
        }

        model.addAttribute("query", query);
        model.addAttribute("itemsPage", itemDocs);
        return "search";
    }
}
