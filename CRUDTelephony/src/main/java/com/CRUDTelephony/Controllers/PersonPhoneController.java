package com.CRUDTelephony.Controllers;

import com.CRUDTelephony.Dto.PersonPhoneDto;
import com.CRUDTelephony.Mappers.PersonPhoneMapper;
import com.CRUDTelephony.Models.Filter;
import com.CRUDTelephony.Models.PersonPhone;
import com.CRUDTelephony.Services.PersonPhoneService;
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

    public PersonPhoneController(PersonPhoneService personPhoneService) {
        super();
        this.personPhoneService = personPhoneService;
    }

    @GetMapping
    public List<PersonPhoneDto> getAllPersonPhones(Filter filter) {

        return personPhoneService.getAll(filter).stream().map(personPhone -> PersonPhoneMapper.mapToPersonPhoneDto(personPhone)).collect(Collectors.toList());
    }

    @GetMapping("/{idOrPhoneNumber}")
    public ResponseEntity<PersonPhoneDto> getByIdOrPhoneNumber(@PathVariable(name = "id") int id) {
        PersonPhone personPhone = personPhoneService.getById(id);

        PersonPhoneDto responsePersonPhone = PersonPhoneMapper.mapToPersonPhoneDto(personPhone);

        return ResponseEntity.ok().body(responsePersonPhone);
    }

    @PostMapping
    public ResponseEntity<PersonPhoneDto> createPersonPhone(@RequestBody PersonPhoneDto personPhoneDto) {
        PersonPhone personPhoneRequest = PersonPhoneMapper.mapToPersonPhone(personPhoneDto);

        PersonPhone personPhone = personPhoneService.create(personPhoneRequest);

        PersonPhoneDto personPhoneResponse = PersonPhoneMapper.mapToPersonPhoneDto(personPhone);

        return new ResponseEntity<PersonPhoneDto>(personPhoneResponse, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonPhoneDto> updatePersonPhone(@PathVariable int id, @RequestBody PersonPhoneDto personPhoneDto) {
        PersonPhone personPhoneRequest = PersonPhoneMapper.mapToPersonPhone(personPhoneDto);
        PersonPhone personPhone = personPhoneService.update(id, personPhoneRequest);
        PersonPhoneDto personPhoneResponse = PersonPhoneMapper.mapToPersonPhoneDto(personPhone);
        return ResponseEntity.ok().body(personPhoneResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePersonPhone(@PathVariable(name = "id") int id) {
        personPhoneService.delete(id);
        return new ResponseEntity<>("Person phone deleted successfully", HttpStatus.OK);
    }
}
