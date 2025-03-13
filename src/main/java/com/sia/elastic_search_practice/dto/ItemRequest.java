package com.sia.elastic_search_practice.dto;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Field;

@Data
public class ItemRequest {
    String itemName;
    String description;
    String place;
}
