package com.CRUDTelephony.Services;

import com.CRUDTelephony.Models.Filter;
import com.CRUDTelephony.Models.PersonPhone;

import java.util.List;

public interface IPersonPhoneService {
    List<PersonPhone> getAll(Filter filter);
    PersonPhone getById(int id);
    PersonPhone getByPhone(String phoneNumber);
    PersonPhone create(PersonPhone personPhone);
    PersonPhone updateById(int id, PersonPhone personPhone);
    PersonPhone updateByPhone(String phoneNumber, PersonPhone personPhone);
    void deleteById(int id);
    void deleteByPhone(String phoneNumber);
}
