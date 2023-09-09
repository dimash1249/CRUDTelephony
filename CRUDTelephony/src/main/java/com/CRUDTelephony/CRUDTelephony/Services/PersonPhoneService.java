package com.CRUDTelephony.CRUDTelephony.Services;

import com.CRUDTelephony.CRUDTelephony.Exceptions.ResourceNotFoundException;
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
    public PersonPhone getById(String idOrPhoneNumber){


        PersonPhone personPhone = getPersonPhoneByIdOrPhoneNumber(idOrPhoneNumber);
        //if(personPhone.isPresent()){
         //   return personPhone.get();
        //}
        //else {
         //   throw new ResourceNotFoundException("Person phone with id " + id + " is not found");
        //}
    }

    @Override
    public PersonPhone create(PersonPhone personPhone) {
        return personPhoneRepository.save(personPhone);
    }

    //@Override
    public PersonPhone update(String idOrPhoneNumber, PersonPhone personPhoneRequest) {
        PersonPhone personPhone = getPersonPhoneByIdOrPhoneNumber(idOrPhoneNumber);
        personPhone.setName(personPhoneRequest.getName());
        personPhone.setBirthYear(personPhoneRequest.getBirthYear());
        personPhone.setPhoneFirst(personPhoneRequest.getPhoneFirst());
        personPhone.setPhoneSecond(personPhoneRequest.getPhoneSecond());
        return personPhoneRepository.save(personPhone);
    }

    @Override
    public void delete(String idOrPhoneNumber){
        PersonPhone personPhone = getPersonPhoneByIdOrPhoneNumber(idOrPhoneNumber);
        personPhoneRepository.delete(personPhone);
    }

    public PersonPhone getPersonPhoneByIdOrPhoneNumber(String idOrPhoneNumber) {
        PersonPhone personPhone;
        if(idOrPhoneNumber.split("")[0].equals("+")) {
            personPhone = personPhoneRepository.findByPhoneNumber(idOrPhoneNumber).orElseThrow(() -> new ResourceNotFoundException("Person phone with id or phone number " + idOrPhoneNumber + " is not found"));
        }
        else {
            personPhone = personPhoneRepository.findById(Integer.parseInt(idOrPhoneNumber)).orElseThrow(() -> new ResourceNotFoundException("Person phone with id or phone number " + idOrPhoneNumber + " is not found"));
        }
        return personPhone;
    }

}
