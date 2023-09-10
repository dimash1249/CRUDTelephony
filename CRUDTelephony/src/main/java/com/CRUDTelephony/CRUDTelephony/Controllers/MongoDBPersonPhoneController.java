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

import static com.CRUDTelephony.CRUDTelephony.Mappers.MongoDBPersonPhoneMapper.*;

@RestController
@RequestMapping("/api/mongodb")
public class MongoDBPersonPhoneController {

    private final MongoDBPersonPhoneService mongoDBPersonPhoneService;

    @Autowired
    public MongoDBPersonPhoneController(MongoDBPersonPhoneService mongoDBPersonPhoneService1) {
        this.mongoDBPersonPhoneService = mongoDBPersonPhoneService1;
    }

    @GetMapping
    public List<MongoDBPersonPhoneDto> getAll(@RequestBody Filter filter) {
        return mongoDBPersonPhoneService.getAll(filter).stream().map(MongoDBPersonPhoneMapper::mapToPersonPhoneDto).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MongoDBPersonPhoneDto> getByIdOrPhoneNumber(@PathVariable(name = "id") String id) {
        MongoDBPersonPhone mongoDBPersonPhone = mongoDBPersonPhoneService.getByIdOrPhoneNumber(id);
        MongoDBPersonPhoneDto mongoDBPersonPhoneDto = mapToPersonPhoneDto(mongoDBPersonPhone);
        return ResponseEntity.ok().body(mongoDBPersonPhoneDto);
    }

//    @PostMapping
//    public ResponseEntity<MongoDBPersonPhoneDto> create(@RequestBody MongoDBPersonPhoneDto mongoDBPersonPhoneDto) {
//        MongoDBPersonPhone mongoDBPersonPhone = mapToPersonPhone(mongoDBPersonPhoneDto);
//        return ResponseEntity.ok().body(mapToPersonPhoneDto(mongoDBPersonPhoneService.create(mongoDBPersonPhone)));
//    }

    @PutMapping("/{id}")
    public ResponseEntity<MongoDBPersonPhoneDto> update(@PathVariable String id, @RequestBody MongoDBPersonPhoneDto mongoDBPersonPhoneDto) {
        MongoDBPersonPhone mongoDBPersonPhoneRequest = mapToPersonPhone(mongoDBPersonPhoneDto);
        MongoDBPersonPhone mongoDBPersonPhone = mongoDBPersonPhoneService.update(id, mongoDBPersonPhoneRequest);
        MongoDBPersonPhoneDto mongoDBPersonPhoneResponse = mapToPersonPhoneDto(mongoDBPersonPhone);
        return ResponseEntity.ok().body(mongoDBPersonPhoneResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        mongoDBPersonPhoneService.delete(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }
}
