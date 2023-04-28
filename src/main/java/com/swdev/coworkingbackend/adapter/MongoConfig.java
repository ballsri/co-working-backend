package com.swdev.coworkingbackend.adapter;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongoConfig extends AbstractMongoClientConfiguration {

    @Value("${spring.data.mongodb.url}")
    private String url;

    @Override
    protected String getDatabaseName() {
        return "coworking";
    }

    @Override
    public MongoClient mongoClient() {
        return MongoClients.create(this.url);
    }
}
