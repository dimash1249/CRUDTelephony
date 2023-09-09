package com.CRUDTelephony.Services;

import com.CRUDTelephony.Models.Filter;
import com.CRUDTelephony.Models.PersonPhone;
import com.CRUDTelephony.Repositories.PersonPhoneRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonPhoneService implements IPersonPhoneService {

    private final PersonPhoneRepository personPhoneRepository;

    public PersonPhoneService(PersonPhoneRepository personPhoneRepository){
        super();
        this.personPhoneRepository = personPhoneRepository;
    }

    @Override
    public List<PersonPhone> getAll(Filter filter){
        return personPhoneRepository.findAll();
    }

    @Override
    public PersonPhone getById(int id){
        Optional<PersonPhone> personPhone = personPhoneRepository.findById(id);
        if(personPhone.isPresent()){
            return personPhone.get();
        }
        else {
            //throw new ResourceNotFoundException("PersonPhone", "id", id);
        }
        return new PersonPhone();
    }

    @Override
    public PersonPhone create(PersonPhone personPhone) {
        return personPhoneRepository.save(personPhone);
    }

    //@Override
    public PersonPhone update(String idOrPhoneNumber, PersonPhone personPhone) {

        //if(idOrPhoneNumber.split("")[0].equals("+")) {
//
        //}
        return new PersonPhone();
    }

    //@Override
    public void delete(int id){
        //PersonPhone personPhone = personPhoneRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("PersonPhone", "id", id));
        //personPhoneRepository.delete(personPhone);
    }
}
