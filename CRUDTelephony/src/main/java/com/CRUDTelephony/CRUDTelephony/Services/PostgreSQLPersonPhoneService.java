package com.CRUDTelephony.CRUDTelephony.Services;

import com.CRUDTelephony.CRUDTelephony.Exceptions.ResourceNotFoundException;
import com.CRUDTelephony.CRUDTelephony.Models.Filter;
import com.CRUDTelephony.CRUDTelephony.Models.PostgreSQLPersonPhone;
import com.CRUDTelephony.CRUDTelephony.Repositories.PostgreSQLPersonPhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Component
@Service
public class PostgreSQLPersonPhoneService implements IPostgreSQLPersonPhoneService {

    private final PostgreSQLPersonPhoneRepository postgreSQLPersonPhoneRepository;

    @Autowired
    public PostgreSQLPersonPhoneService(PostgreSQLPersonPhoneRepository postgreSQLPersonPhoneRepository){
        this.postgreSQLPersonPhoneRepository = postgreSQLPersonPhoneRepository;
    }

    @Override
    public List<PostgreSQLPersonPhone> getAll(Filter filter){
        return postgreSQLPersonPhoneRepository.getAll(filter.limit, filter.offset);
    }

    @Override
    public PostgreSQLPersonPhone getByIdOrPhoneNumber(String idOrPhoneNumber){
        return getPersonPhoneByIdOrPhoneNumber(idOrPhoneNumber);
    }

//    @Override
//    public PersonPhone create(PersonPhone personPhone) {
//        return personPhoneRepository.save(personPhone);
//    }

    @Override
    public PostgreSQLPersonPhone update(String idOrPhoneNumber, PostgreSQLPersonPhone postgreSQLPersonPhoneRequest) {
        PostgreSQLPersonPhone postgreSQLPersonPhone = getPersonPhoneByIdOrPhoneNumber(idOrPhoneNumber);
        postgreSQLPersonPhone.setName(postgreSQLPersonPhoneRequest.getName());
        postgreSQLPersonPhone.setBirthYear(postgreSQLPersonPhoneRequest.getBirthYear());
        postgreSQLPersonPhone.setPhoneFirst(postgreSQLPersonPhoneRequest.getPhoneFirst());
        postgreSQLPersonPhone.setPhoneSecond(postgreSQLPersonPhoneRequest.getPhoneSecond());
        return postgreSQLPersonPhoneRepository.save(postgreSQLPersonPhone);
    }

    @Override
    public void delete(String id){
        PostgreSQLPersonPhone postgreSQLPersonPhone = getPersonPhoneByIdOrPhoneNumber(id);
        if(postgreSQLPersonPhone != null) {
            postgreSQLPersonPhoneRepository.delete(postgreSQLPersonPhone);
        }
        else {
            throw new ResourceNotFoundException("Error not deleted");
        }
    }

    public PostgreSQLPersonPhone getPersonPhoneByIdOrPhoneNumber(String idOrPhoneNumber) {
        Optional<PostgreSQLPersonPhone> personPhone;
        char[] mas = idOrPhoneNumber.toCharArray();
        if(mas[0] == '+') {
            PostgreSQLPersonPhone postgreSQLPersonPhoneid = postgreSQLPersonPhoneRepository.findByPhoneNumber(idOrPhoneNumber);
            if(postgreSQLPersonPhoneid != null){
                return postgreSQLPersonPhoneid;
            }
            else {
                throw new ResourceNotFoundException("Person phone with id or phone number " + idOrPhoneNumber + " is not found");
            }
        }
        else {
            personPhone = postgreSQLPersonPhoneRepository.findById(Integer.parseInt(idOrPhoneNumber));
            if(personPhone.isPresent()) {
                return personPhone.get();
            }
            else {
                throw new ResourceNotFoundException("Person phone with id or phone number " + idOrPhoneNumber + " is not found");
            }
        }
    }
}
