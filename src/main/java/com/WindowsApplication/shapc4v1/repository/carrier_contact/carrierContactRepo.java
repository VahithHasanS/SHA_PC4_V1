package com.WindowsApplication.shapc4v1.repository.carrier_contact;

import com.WindowsApplication.shapc4v1.entity.carrier_contact.carrierContactEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface carrierContactRepo extends MongoRepository<carrierContactEntity, String> {
    @Query("{ 'Name': ?0 }")
    Optional<List<carrierContactEntity>> findByName(String Name);

    @Query("{ 'PinCode': ?0 }")
    Optional<carrierContactEntity> findByPinCode(String PinCode);

    @Query("{ 'PinCode': ?0 }")
    Optional<carrierContactEntity> existPinCode(String PinCode);
}
