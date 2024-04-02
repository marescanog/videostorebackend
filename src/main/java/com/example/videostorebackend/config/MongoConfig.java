package com.example.videostorebackend.config;

import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongoConfig {

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(MongoClients.create("mongodb+srv://<USERNAME>:<PASSWORD>@cluster0.mz9lbam.mongodb.net/videostore?retryWrites=true"), "videostore");
    }
}
