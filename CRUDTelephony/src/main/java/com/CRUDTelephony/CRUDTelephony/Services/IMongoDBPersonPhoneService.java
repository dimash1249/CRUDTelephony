package com.CRUDTelephony.CRUDTelephony.Services;

import com.CRUDTelephony.CRUDTelephony.Models.Filter;
import com.CRUDTelephony.CRUDTelephony.Models.MongoDBPersonPhone;
import com.CRUDTelephony.CRUDTelephony.Models.PostgreSQLPersonPhone;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IMongoDBPersonPhoneService {
    List<MongoDBPersonPhone> getAll(Filter filter);
    MongoDBPersonPhone getByIdOrPhoneNumber(String idOrPhoneNumber);
//    MongoDBPersonPhone create(MongoDBPersonPhone personPhone);
    MongoDBPersonPhone update(String idOrPhoneNumber, MongoDBPersonPhone mongoDBPersonPhone);
    void delete(String id);
}
