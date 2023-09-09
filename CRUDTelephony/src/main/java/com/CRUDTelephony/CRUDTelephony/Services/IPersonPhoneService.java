package com.CRUDTelephony.CRUDTelephony.Services;

import com.CRUDTelephony.CRUDTelephony.Models.Filter;
import com.CRUDTelephony.CRUDTelephony.Models.PersonPhone;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IPersonPhoneService {
    List<PersonPhone> getAll(Filter filter);
    PersonPhone getByIdOrPhoneNumber(String idOrPhoneNumber);
    PersonPhone create(PersonPhone personPhone);
    PersonPhone update(String idOrPhoneNumber, PersonPhone personPhone);
    void delete(String idOrPhoneNumber);
}
