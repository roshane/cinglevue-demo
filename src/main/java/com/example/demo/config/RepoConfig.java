package com.example.demo.config;

import com.example.demo.DemoApplication;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Created by roshane on 9/3/17.
 */
@Configuration
@EnableMongoRepositories(basePackageClasses = {DemoApplication.class})
public class RepoConfig extends AbstractMongoConfiguration {

    private final String dbName;
    private final String host;

    RepoConfig(@Value("${spring.data.mongodb.database}") String dbName,
               @Value("${spring.data.mongodb.host}") String host) {
        this.host = host;
        this.dbName = dbName;
    }

    @Override
    protected String getDatabaseName() {
        return dbName;
    }

    @Override
    public Mongo mongo() throws Exception {
        return new MongoClient(host);
    }
}
