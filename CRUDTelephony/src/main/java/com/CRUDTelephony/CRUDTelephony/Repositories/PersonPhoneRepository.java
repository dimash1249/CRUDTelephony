package com.CRUDTelephony.CRUDTelephony.Repositories;

import com.CRUDTelephony.CRUDTelephony.Models.Filter;
import com.CRUDTelephony.CRUDTelephony.Models.PersonPhone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonPhoneRepository extends JpaRepository<PersonPhone, Integer> {

    //public List<PersonPhone> findBYPhoneNumber(String phoneNumber);
    //public void deleteByPhoneNumber(String phoneNumber);
    //public List<PersonPhone> finbByLimitAndOffset(Filter filter);
    //@Modifying
    //@Query("UPDATE PersonPhones SET id = 12345")
    //public void updatePersonPhoneByPhoneNumber(String phoneNumber, PersonPhone personPhone);
}
