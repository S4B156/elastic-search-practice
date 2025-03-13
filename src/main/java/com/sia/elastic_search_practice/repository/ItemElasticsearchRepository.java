package com.sia.elastic_search_practice.repository;

import com.sia.elastic_search_practice.entity.ItemDoc;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemElasticsearchRepository extends ElasticsearchRepository<ItemDoc, String> {
    @Query("{\"multi_match\": {\"query\": \"?0\", \"fields\": [\"itemName\", \"description\", \"place\"]}}")
    Page<ItemDoc> searchByQuery(String query, Pageable pageable);
}
