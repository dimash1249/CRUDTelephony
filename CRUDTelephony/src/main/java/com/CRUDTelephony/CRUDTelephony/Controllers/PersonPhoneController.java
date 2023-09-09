package com.CRUDTelephony.CRUDTelephony.Controllers;

import com.CRUDTelephony.CRUDTelephony.Dto.PersonPhoneDto;
import com.CRUDTelephony.CRUDTelephony.Mappers.PersonPhoneMapper;
import com.CRUDTelephony.CRUDTelephony.Models.Filter;
import com.CRUDTelephony.CRUDTelephony.Models.PersonPhone;
import com.CRUDTelephony.CRUDTelephony.Services.PersonPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/person-phones")
public class PersonPhoneController {

    private PersonPhoneService personPhoneService;

    @Autowired
    public PersonPhoneController(PersonPhoneService personPhoneService) {
        this.personPhoneService = personPhoneService;
    }

    @GetMapping("/list")
    public List<PersonPhoneDto> getAllPersonPhones(@RequestBody Filter filter) {
        return personPhoneService.getAll(filter).stream().map(personPhone -> PersonPhoneMapper.mapToPersonPhoneDto(personPhone)).collect(Collectors.toList());
    }

    @GetMapping("/by-id-or-phone-number/{id}")
    public ResponseEntity<PersonPhoneDto> getByIdOrPhoneNumber(@PathVariable(name = "id") String idOrPhoneNumber) {
        PersonPhone personPhone = personPhoneService.getByIdOrPhoneNumber(idOrPhoneNumber);
        PersonPhoneDto responsePersonPhone = PersonPhoneMapper.mapToPersonPhoneDto(personPhone);
        return ResponseEntity.ok().body(responsePersonPhone);
    }

//    @PostMapping
//    public ResponseEntity<PersonPhoneDto> createPersonPhone(@RequestBody PersonPhoneDto personPhoneDto) {
//        PersonPhone personPhoneRequest = PersonPhoneMapper.mapToPersonPhone(personPhoneDto);
//        PersonPhone personPhone = personPhoneService.create(personPhoneRequest);
//        PersonPhoneDto personPhoneResponse = PersonPhoneMapper.mapToPersonPhoneDto(personPhone);
//        return new ResponseEntity<PersonPhoneDto>(personPhoneResponse, HttpStatus.CREATED);
//    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonPhoneDto> updatePersonPhone(@PathVariable String id, @RequestBody PersonPhoneDto personPhoneDto) {
        PersonPhone personPhoneRequest = PersonPhoneMapper.mapToPersonPhone(personPhoneDto);
        PersonPhone personPhone = personPhoneService.update(id, personPhoneRequest);
        PersonPhoneDto personPhoneResponse = PersonPhoneMapper.mapToPersonPhoneDto(personPhone);
        return ResponseEntity.ok().body(personPhoneResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePersonPhone(@PathVariable(name = "id") String id) {
        personPhoneService.delete(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }
}
