package com.CRUDTelephony.CRUDTelephony.MongoDB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements ApplicationRunner {

        private final MongoDBSeeder mongoDBSeeder;

        @Autowired
        public DataInitializer(MongoDBSeeder mongoDBSeeder) {
            this.mongoDBSeeder = mongoDBSeeder;
        }

        @Override
        public void run(ApplicationArguments args) {
            mongoDBSeeder.seedData();
        }
}
