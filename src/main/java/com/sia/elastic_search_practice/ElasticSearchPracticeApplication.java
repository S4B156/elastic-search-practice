package com.sia.elastic_search_practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootApplication
@EnableElasticsearchRepositories
public class ElasticSearchPracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElasticSearchPracticeApplication.class, args);
	}

}
