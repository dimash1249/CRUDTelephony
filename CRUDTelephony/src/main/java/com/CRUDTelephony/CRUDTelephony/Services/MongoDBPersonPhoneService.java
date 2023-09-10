package com.CRUDTelephony.CRUDTelephony.Services;

import com.CRUDTelephony.CRUDTelephony.Controllers.MongoDBPersonPhoneController;
import com.CRUDTelephony.CRUDTelephony.Exceptions.ResourceNotFoundException;
import com.CRUDTelephony.CRUDTelephony.Models.Filter;
import com.CRUDTelephony.CRUDTelephony.Models.MongoDBPersonPhone;
import com.CRUDTelephony.CRUDTelephony.Models.PostgreSQLPersonPhone;
import com.CRUDTelephony.CRUDTelephony.Repositories.MongoDBPersonPhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Component
@Service
public class MongoDBPersonPhoneService implements IMongoDBPersonPhoneService {

    private final MongoDBPersonPhoneRepository mongoDBPersonPhoneRepository;

    @Autowired
    public MongoDBPersonPhoneService(MongoDBPersonPhoneRepository mongoDBPersonPhoneRepository) {
        this.mongoDBPersonPhoneRepository = mongoDBPersonPhoneRepository;
    }


    @Override
    public List<MongoDBPersonPhone> getAll(Filter filter) {
        return mongoDBPersonPhoneRepository.getAll(filter.limit, filter.offset);
    }

    @Override
    public MongoDBPersonPhone getByIdOrPhoneNumber(String idOrPhoneNumber) {
        MongoDBPersonPhone mongoDBPersonPhone = getMongoDBPersonPhoneByIdOrPhoneNumber(idOrPhoneNumber);
        return mongoDBPersonPhone;
    }

    @Override
    public MongoDBPersonPhone create(MongoDBPersonPhone mongoDBPersonPhone) {
        return mongoDBPersonPhoneRepository.save(mongoDBPersonPhone);
    }
    @Override
    public MongoDBPersonPhone update(String idOrPhoneNumber, MongoDBPersonPhone mongoDBPersonPhoneRequest) {
        MongoDBPersonPhone mongoDBPersonPhone = getMongoDBPersonPhoneByIdOrPhoneNumber(idOrPhoneNumber);
        mongoDBPersonPhone.setName(mongoDBPersonPhoneRequest.getName());
        mongoDBPersonPhone.setBirthYear(mongoDBPersonPhoneRequest.getBirthYear());
        mongoDBPersonPhone.setPhoneFirst(mongoDBPersonPhoneRequest.getPhoneFirst());
        mongoDBPersonPhone.setPhoneSecond(mongoDBPersonPhoneRequest.getPhoneSecond());
        return mongoDBPersonPhoneRepository.save(mongoDBPersonPhone);
    }

    @Override
    public void delete(String id) {
        MongoDBPersonPhone mongoDBPersonPhone = getMongoDBPersonPhoneByIdOrPhoneNumber(id);
        if(mongoDBPersonPhone != null) {
            mongoDBPersonPhoneRepository.delete(mongoDBPersonPhone);
        }
        else {
            throw new ResourceNotFoundException("Error");
        }
    }

    public MongoDBPersonPhone getMongoDBPersonPhoneByIdOrPhoneNumber(String idOrPhoneNumber) {
        char[] mas = idOrPhoneNumber.toCharArray();
        if(mas[0] == '+') {
            MongoDBPersonPhone mongoDBPersonPhone = mongoDBPersonPhoneRepository.findAllByPhoneFirstOrPhoneSecond(idOrPhoneNumber);
//            if(mongoDBPersonPhone != null) {
                return mongoDBPersonPhone;
            }
//            else {
//                MongoDBPersonPhone mongoDBPersonPhoneSecond = mongoDBPersonPhoneRepository.findAllByPhoneSecond(idOrPhoneNumber);
//                if(mongoDBPersonPhoneSecond != null) {
//                    return mongoDBPersonPhoneSecond;
//                }
//                else {
//                    throw new ResourceNotFoundException("Error");
//                }
//            }
//        }
        else {
            Optional<MongoDBPersonPhone> mongoDBPersonPhone = mongoDBPersonPhoneRepository.findById(idOrPhoneNumber);
            if(mongoDBPersonPhone.isPresent()) {
                return mongoDBPersonPhone.get();
            }
            else {
                throw new ResourceNotFoundException("Error");
            }
        }
    }
}
