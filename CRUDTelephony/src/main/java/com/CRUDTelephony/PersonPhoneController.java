package com.CRUDTelephony;

import com.CRUDTelephony.Dto.PersonPhoneDto;
import com.CRUDTelephony.Models.Filter;
import com.CRUDTelephony.Models.PersonPhone;
import com.CRUDTelephony.Services.PersonPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/person-phones")
public class PersonPhoneController {

    @Autowired
    private ModelMapper modelMapper;

    private PersonPhoneService personPhoneService;

    public PersonPhoneController(PersonPhoneService personPhoneService) {
        super();
        this.personPhoneService = personPhoneService;
    }

    @GetMapping
    public List<PersonPhoneDto> getAllPersonPhones(Filter filter) {

        return personPhoneService.getAll(filter).stream().map(personPhone -> modelMapper.map(personPhone, PersonPhoneDto.class)).collect(Collectors.toList());
    }

    @GetMapping("/{idOrPhoneNumber}")
    public ResponseEntity<PersonPhoneDto> getByIdOrPhoneNumber(@PathVariable(name = "id") int id) {
        PersonPhone personPhone = personPhoneService.getById(id);

        PersonPhoneDto responsePersonPhone = modelMapper.map(personPhone, PersonPhoneDto.class);

        return ResponseEntity.ok().body(responsePersonPhone);
    }

    @PostMapping
    public
}
