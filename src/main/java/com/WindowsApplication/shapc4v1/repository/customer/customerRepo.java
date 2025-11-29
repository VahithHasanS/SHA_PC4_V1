package com.WindowsApplication.shapc4v1.repository.customer;

import com.WindowsApplication.shapc4v1.entity.customer.customerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface customerRepo extends MongoRepository<customerEntity, String> {
    @Query("{ 'Name': ?0 }")
    Optional<List<customerEntity>> findByName(String Name);

    @Query("{ 'Booking_AccountType': ?0 }")
    Optional<List<customerEntity>> findByBooking_AccountType(String Booking_AccountType);

    @Query(" { 'MobileNumber': ?0} ")
    Optional<customerEntity> findByMobileNumber(String MobileNumber);

    @Query("{ 'Name': ?0 }")
    Optional<customerEntity> existCustomer(String Name);
}
