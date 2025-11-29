package com.WindowsApplication.shapc4v1.service.delivery_Status;

import com.WindowsApplication.shapc4v1.entity.delivery_status.deliveryStatusEntity;
import com.WindowsApplication.shapc4v1.repository.delivery_Status.deliveryStatusRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class deliveryStatusService {
    private final deliveryStatusRepo DeliveryStatusRepo;

    public List<deliveryStatusEntity> findAllStatus() {
        return DeliveryStatusRepo.findAll();
    }

    public Optional<List<deliveryStatusEntity>> findByFrom_Name(String From_Name) {
        return DeliveryStatusRepo.findByFrom_Name(From_Name);
    }

    public Optional<deliveryStatusEntity> findByBooking_Number(String Booking_Number) {
        return DeliveryStatusRepo.findByBooking_Number(Booking_Number);
    }

    public Optional<List<deliveryStatusEntity>> findByStatus(String Status) {
        return DeliveryStatusRepo.findByStatus(Status);
    }

    public deliveryStatusEntity createStatus(deliveryStatusEntity status) {
        if (DeliveryStatusRepo.existBooking_Number(status.getBooking_Number()).toString().equals(status.getBooking_Number())) {
            throw new RuntimeException("Status with booking number: " + status.getBooking_Number() + " is already existed");
        }
        return DeliveryStatusRepo.save(status);
    }

    public deliveryStatusEntity updateStatus(String id, deliveryStatusEntity statusDetail) {
        return DeliveryStatusRepo.findById(id).map(
                status -> {
                    status.setStatus(statusDetail.getStatus());
                    status.setBooking_Number(statusDetail.getBooking_Number());
                    status.setFrom_Name(statusDetail.getFrom_Name());
                    status.setTo_Name(statusDetail.getTo_Name());
                    status.setDelivered_Date(statusDetail.getDelivered_Date());
                    status.setUpload_on_Online(statusDetail.isUpload_on_Online());
                    return DeliveryStatusRepo.save(status);
                }
        ).orElseThrow(() -> new RuntimeException("Status not found with id: " + id));
    }

    public void deleteStatus(String id) {
        DeliveryStatusRepo.deleteById(id);
    }
}
