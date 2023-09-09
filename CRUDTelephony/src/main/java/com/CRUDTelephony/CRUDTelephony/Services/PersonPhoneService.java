package com.CRUDTelephony.CRUDTelephony.Services;

import com.CRUDTelephony.CRUDTelephony.Models.Filter;
import com.CRUDTelephony.CRUDTelephony.Models.PersonPhone;
import com.CRUDTelephony.CRUDTelephony.Repositories.PersonPhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Component
@Service
public class PersonPhoneService implements IPersonPhoneService {

    private final PersonPhoneRepository personPhoneRepository;

    @Autowired
    public PersonPhoneService(PersonPhoneRepository personPhoneRepository){
        this.personPhoneRepository = personPhoneRepository;
    }

    @Override
    public List<PersonPhone> getAll(){
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
