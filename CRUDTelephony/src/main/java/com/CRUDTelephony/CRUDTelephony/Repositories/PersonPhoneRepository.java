package com.CRUDTelephony.CRUDTelephony.Repositories;

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
    @Query(value = "SELECT * FROM person_phones WHERE person_phone_first = ?1 OR person_phone_second = ?1", nativeQuery = true)
    public PersonPhone findByPhoneNumber(String phoneNumber);
}
