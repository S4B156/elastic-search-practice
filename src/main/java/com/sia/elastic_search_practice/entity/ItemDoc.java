package com.sia.elastic_search_practice.entity;

import com.sia.elastic_search_practice.dto.ItemRequest;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "items_index")
@NoArgsConstructor
@AllArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ItemDoc {
    @Id
    String id;
    @Field(type = FieldType.Text, analyzer = "russian_analyzer")
    String itemName;
    @Field(type = FieldType.Text, analyzer = "russian_analyzer")
    String description;
    @Field(type = FieldType.Text, analyzer = "russian_analyzer")
    String place;

    public ItemDoc(String itemName, String description, String place) {
        this.itemName = itemName;
        this.description = description;
        this.place = place;
    }
}
