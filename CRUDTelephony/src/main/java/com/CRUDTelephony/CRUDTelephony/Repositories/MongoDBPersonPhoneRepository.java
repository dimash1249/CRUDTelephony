package com.CRUDTelephony.CRUDTelephony.Repositories;

import com.CRUDTelephony.CRUDTelephony.Models.MongoDBPersonPhone;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MongoDBPersonPhoneRepository extends MongoRepository<MongoDBPersonPhone, Integer> {

    @Aggregation(pipeline = {"{ '$skip':  ?1}", "{ '$limit':  ?0}"})
    List<MongoDBPersonPhone> getAll(int limit, int offset);
    MongoDBPersonPhone findByPhoneFirst(String phoneFirst);
    MongoDBPersonPhone findByPhoneSecond(String phoneSecond);
}
