package com.WindowsApplication.shapc4v1.repository.delivery_Status;

import com.WindowsApplication.shapc4v1.entity.delivery_status.deliveryStatusEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface deliveryStatusRepo extends MongoRepository<deliveryStatusEntity, String> {
    @Query("{ 'From_Name': ?0 }")
    Optional<List<deliveryStatusEntity>> findByFrom_Name(String From_Name);

    @Query("{ 'Booking_Number': ?0 }")
    Optional<deliveryStatusEntity> findByBooking_Number(String Booking_Number);

    @Query(" { 'Status': ?0} ")
    Optional<List<deliveryStatusEntity>> findByStatus(String Status);

    @Query("{ 'Booking_Number': ?0 }")
    Optional<deliveryStatusEntity> existBooking_Number(String Booking_Number);
}
