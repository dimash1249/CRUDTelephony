package com.CRUDTelephony.CRUDTelephony.Services;

import com.CRUDTelephony.CRUDTelephony.Models.Filter;
import com.CRUDTelephony.CRUDTelephony.Models.PostgreSQLPersonPhone;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IPostgreSQLPersonPhoneService {
    List<PostgreSQLPersonPhone> getAll(Filter filter);
    PostgreSQLPersonPhone getByIdOrPhoneNumber(String idOrPhoneNumber);
//    PersonPhone create(PersonPhone personPhone);
    PostgreSQLPersonPhone update(String idOrPhoneNumber, PostgreSQLPersonPhone postgreSQLPersonPhone);
    void delete(String id);
}
