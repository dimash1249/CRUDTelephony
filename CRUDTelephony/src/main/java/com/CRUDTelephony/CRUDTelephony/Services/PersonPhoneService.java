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
    public List<PersonPhone> getAll(Filter filter){
        return personPhoneRepository.getAll(filter.limit, filter.offset);
    }

    @Override
    public PersonPhone getByIdOrPhoneNumber(String idOrPhoneNumber){
        PersonPhone personPhone = getPersonPhoneByIdOrPhoneNumber(idOrPhoneNumber);
        return personPhone;
    }

//    @Override
//    public PersonPhone create(PersonPhone personPhone) {
//        return personPhoneRepository.save(personPhone);
//    }

    @Override
    public PersonPhone update(String idOrPhoneNumber, PersonPhone personPhoneRequest) {
        PersonPhone personPhone = getPersonPhoneByIdOrPhoneNumber(idOrPhoneNumber);
        personPhone.setName(personPhoneRequest.getName());
        personPhone.setBirthYear(personPhoneRequest.getBirthYear());
        personPhone.setPhoneFirst(personPhoneRequest.getPhoneFirst());
        personPhone.setPhoneSecond(personPhoneRequest.getPhoneSecond());
        return personPhoneRepository.save(personPhone);
    }

    @Override
    public void delete(String id){
        PersonPhone personPhone = getPersonPhoneByIdOrPhoneNumber(id);
        if(personPhone != null) {
            personPhoneRepository.delete(personPhone);
        }
        else {
            throw new ResourceNotFoundException("Error not deleted");
        }
    }

    public PersonPhone getPersonPhoneByIdOrPhoneNumber(String idOrPhoneNumber) {
        Optional<PersonPhone> personPhone;
        char[] mas = idOrPhoneNumber.toCharArray();
        if(mas[0] == '+') {
            PersonPhone personPhoneid = personPhoneRepository.findByPhoneNumber(idOrPhoneNumber);
            if(personPhoneid != null){
                return personPhoneid;
            }
            else {
                throw new ResourceNotFoundException("Person phone with id or phone number " + idOrPhoneNumber + " is not found");
            }
        }
        else {
            personPhone = personPhoneRepository.findById(Integer.parseInt(idOrPhoneNumber));
            if(personPhone.isPresent()) {
                return personPhone.get();
            }
            else {
                throw new ResourceNotFoundException("Person phone with id or phone number " + idOrPhoneNumber + " is not found");
            }
        }
    }
}
