package com.CRUDTelephony.CRUDTelephony.Controllers;

import com.CRUDTelephony.CRUDTelephony.Dto.PostgreSQLPersonPhoneDto;
import com.CRUDTelephony.CRUDTelephony.Mappers.PostgreSQLPersonPhoneMapper;
import com.CRUDTelephony.CRUDTelephony.Models.Filter;
import com.CRUDTelephony.CRUDTelephony.Models.PostgreSQLPersonPhone;
import com.CRUDTelephony.CRUDTelephony.Services.PostgreSQLPersonPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static com.CRUDTelephony.CRUDTelephony.Mappers.PostgreSQLPersonPhoneMapper.*;

@RestController
@RequestMapping("/api/person-phones")
public class PostgreSQLPersonPhoneController {

    private final PostgreSQLPersonPhoneService personPhoneService;

    @Autowired
    public PostgreSQLPersonPhoneController(PostgreSQLPersonPhoneService personPhoneService) {
        this.personPhoneService = personPhoneService;
    }

    @GetMapping("/list")
    public List<PostgreSQLPersonPhoneDto> getAllPersonPhones(@RequestBody Filter filter) {
        return personPhoneService.getAll(filter).stream().map(PostgreSQLPersonPhoneMapper::mapToPersonPhoneDto).collect(Collectors.toList());
    }

    @GetMapping("/by-id-or-phone-number/{id}")
    public ResponseEntity<PostgreSQLPersonPhoneDto> getByIdOrPhoneNumber(@PathVariable(name = "id") String idOrPhoneNumber) {
        PostgreSQLPersonPhone postgreSQLPersonPhone = personPhoneService.getByIdOrPhoneNumber(idOrPhoneNumber);
        PostgreSQLPersonPhoneDto responsePersonPhone = mapToPersonPhoneDto(postgreSQLPersonPhone);
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
    public ResponseEntity<PostgreSQLPersonPhoneDto> updatePersonPhone(@PathVariable String id, @RequestBody PostgreSQLPersonPhoneDto postgreSQLPersonPhoneDto) {
        PostgreSQLPersonPhone postgreSQLPersonPhoneRequest = mapToPersonPhone(postgreSQLPersonPhoneDto);
        PostgreSQLPersonPhone postgreSQLPersonPhone = personPhoneService.update(id, postgreSQLPersonPhoneRequest);
        PostgreSQLPersonPhoneDto personPhoneResponse = mapToPersonPhoneDto(postgreSQLPersonPhone);
        return ResponseEntity.ok().body(personPhoneResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePersonPhone(@PathVariable(name = "id") String id) {
        personPhoneService.delete(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }
}
