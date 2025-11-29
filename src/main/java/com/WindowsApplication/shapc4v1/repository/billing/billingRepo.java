package com.WindowsApplication.shapc4v1.repository.billing;

import com.WindowsApplication.shapc4v1.entity.billing.billingEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface billingRepo extends MongoRepository<billingEntity, String> {
    @Query("{ 'From_Name': ?0 }")
    Optional<List<billingEntity>> findByFrom_Name(String From_Name);

    @Query("{ 'Booking_AccountType': ?0 }")
    Optional<List<billingEntity>> findByBooking_AccountType(String Booking_AccountType);

    @Query(" { 'Booking_Number': ?0} ")
    Optional<List<billingEntity>> findByBookingNumber(String Booking_Number);

    @Query("{ 'Booking_Number': ?0 }")
    Optional<billingEntity> existBooking_Number(String Booking_Number);

    @Query("{ 'Status': ?0 }")
    Optional<List<billingEntity>> findByStatus(String Status);
}
