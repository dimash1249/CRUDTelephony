package com.CRUDTelephony.CRUDTelephony.Controllers;

import com.CRUDTelephony.CRUDTelephony.Models.Filter;
import com.CRUDTelephony.CRUDTelephony.Models.MongoDBPersonPhone;
import com.CRUDTelephony.CRUDTelephony.Services.MongoDBPersonPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mongodb")
public class MongoDBPersonPhoneController {

    private MongoDBPersonPhoneService mongoDBPersonPhoneService;

    @Autowired
    public MongoDBPersonPhoneController(MongoDBPersonPhoneService mongoDBPersonPhoneService1) {
        this.mongoDBPersonPhoneService = mongoDBPersonPhoneService1;
    }

    @GetMapping
    public List<MongoDBPersonPhone> getAll(@RequestBody Filter filter) {
        return mongoDBPersonPhoneService.getAll(filter);
    }

    @PostMapping
    public MongoDBPersonPhone create(@RequestBody MongoDBPersonPhone mongoDBPersonPhone) {
        return mongoDBPersonPhoneService.create(mongoDBPersonPhone);
    }
}
