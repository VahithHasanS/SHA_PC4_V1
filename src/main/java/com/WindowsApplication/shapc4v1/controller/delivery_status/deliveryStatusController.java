package com.WindowsApplication.shapc4v1.controller.delivery_status;

import com.WindowsApplication.shapc4v1.entity.delivery_status.deliveryStatusEntity;
import com.WindowsApplication.shapc4v1.service.delivery_Status.deliveryStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/deliveryStatus")
@RequiredArgsConstructor
public class deliveryStatusController {
    private final deliveryStatusService DeliveryStatusService;

    @GetMapping
    public ResponseEntity<List<deliveryStatusEntity>> getAllStatus() {
        return ResponseEntity.ok(DeliveryStatusService.findAllStatus());
    }

    @GetMapping("/From_Name/{From_Name}")
    public ResponseEntity<List<deliveryStatusEntity>> findByFrom_Name(@PathVariable String From_Name){
        return DeliveryStatusService.findByFrom_Name(From_Name).map(ResponseEntity::ok).orElse(ResponseEntity.badRequest().build());
    }

    @GetMapping("/Booking_Number/{Booking_Number}")
    public ResponseEntity<deliveryStatusEntity> getByBooking_Number(@PathVariable String Booking_Number) {
        return DeliveryStatusService.findByBooking_Number(Booking_Number).map(ResponseEntity::ok).orElse(ResponseEntity.badRequest().build());
    }

    @GetMapping("/Status/{Status}")
    public ResponseEntity<List<deliveryStatusEntity>> getByStatus(@PathVariable String Status) {
        return DeliveryStatusService.findByStatus(Status).map(ResponseEntity::ok).orElse(ResponseEntity.badRequest().build());
    }

    @PostMapping
    public ResponseEntity<deliveryStatusEntity> createStatus(@RequestBody deliveryStatusEntity status) {
        try {
            deliveryStatusEntity _createStatus = DeliveryStatusService.createStatus(status);
            return ResponseEntity.ok(_createStatus);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<deliveryStatusEntity> updateStatus(@PathVariable String id, @RequestBody deliveryStatusEntity status) {
        try {
            deliveryStatusEntity _updateStatus = DeliveryStatusService.updateStatus(id, status);
            return ResponseEntity.ok(_updateStatus);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStatus(@PathVariable String id) {
        DeliveryStatusService.deleteStatus(id);
        return ResponseEntity.ok().build();
    }
}
