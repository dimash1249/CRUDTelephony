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

    @Modifying
    @Query(value = "SELECT * FROM person_phones LIMIT ?1 OFFSET ?2", nativeQuery = true)
    public List<PersonPhone> getAll(int limit, int offset);
    @Modifying
    @Query("SELECT p FROM PersonPhone p WHERE p.phoneFirst = :phoneNumber OR p.phoneSecond = :phoneNumber")
    public PersonPhone findByPhoneNumber(String phoneNumber);
    //public List<PersonPhone> findBYPhoneNumber(String phoneNumber);
    //public void deleteByPhoneNumber(String phoneNumber);
    //public List<PersonPhone> finbByLimitAndOffset(Filter filter);
    //@Modifying
    //@Query("UPDATE PersonPhones SET id = 12345")
    //public void updatePersonPhoneByPhoneNumber(String phoneNumber, PersonPhone personPhone);
    //public void findByPhone()
}
