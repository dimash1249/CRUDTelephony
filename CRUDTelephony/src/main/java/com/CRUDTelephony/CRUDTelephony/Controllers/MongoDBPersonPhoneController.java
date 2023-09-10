package com.CRUDTelephony.CRUDTelephony.Controllers;

import com.CRUDTelephony.CRUDTelephony.Dto.MongoDBPersonPhoneDto;
import com.CRUDTelephony.CRUDTelephony.Mappers.MongoDBPersonPhoneMapper;
import com.CRUDTelephony.CRUDTelephony.Models.Filter;
import com.CRUDTelephony.CRUDTelephony.Models.MongoDBPersonPhone;
import com.CRUDTelephony.CRUDTelephony.Services.MongoDBPersonPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/mongodb")
public class MongoDBPersonPhoneController {

    private MongoDBPersonPhoneService mongoDBPersonPhoneService;

    @Autowired
    public MongoDBPersonPhoneController(MongoDBPersonPhoneService mongoDBPersonPhoneService1) {
        this.mongoDBPersonPhoneService = mongoDBPersonPhoneService1;
    }

    @GetMapping
    public List<MongoDBPersonPhoneDto> getAll(@RequestBody Filter filter) {
        return mongoDBPersonPhoneService.getAll(filter).stream().map(mongoDBPersonPhone -> MongoDBPersonPhoneMapper.mapToPersonPhoneDto(mongoDBPersonPhone)).collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<MongoDBPersonPhoneDto> create(@RequestBody MongoDBPersonPhoneDto mongoDBPersonPhoneDto) {
        MongoDBPersonPhone mongoDBPersonPhone = MongoDBPersonPhoneMapper.mapToPersonPhone(mongoDBPersonPhoneDto);
        return ResponseEntity.ok().body(MongoDBPersonPhoneMapper.mapToPersonPhoneDto(mongoDBPersonPhoneService.create(mongoDBPersonPhone)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MongoDBPersonPhoneDto> update(@PathVariable String id, MongoDBPersonPhoneDto mongoDBPersonPhoneDto) {
        MongoDBPersonPhone mongoDBPersonPhoneRequest = MongoDBPersonPhoneMapper.mapToPersonPhone(mongoDBPersonPhoneDto);
        MongoDBPersonPhone mongoDBPersonPhone = mongoDBPersonPhoneService.update(id, mongoDBPersonPhoneRequest);
        MongoDBPersonPhoneDto mongoDBPersonPhoneResponse = MongoDBPersonPhoneMapper.mapToPersonPhoneDto(mongoDBPersonPhone);
        return ResponseEntity.ok().body(mongoDBPersonPhoneResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        mongoDBPersonPhoneService.delete(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }
}
