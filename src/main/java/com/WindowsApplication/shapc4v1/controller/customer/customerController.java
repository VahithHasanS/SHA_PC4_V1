package com.WindowsApplication.shapc4v1.controller.customer;

import com.WindowsApplication.shapc4v1.entity.customer.customerEntity;
import com.WindowsApplication.shapc4v1.service.customer.customerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
public class customerController {
    private final customerService CustomerService;

    @GetMapping
    public ResponseEntity<List<customerEntity>> getAllCustomer() {
        return ResponseEntity.ok(CustomerService.getAllCustomer());
    }

    @GetMapping("/Name/{Name}")
    public ResponseEntity<List<customerEntity>> getCustomerByName(@PathVariable String Name) {
        return CustomerService.getCustomerByName(Name).map(ResponseEntity::ok).orElse(ResponseEntity.badRequest().build());
    }

    @GetMapping("/Booking_AccountType/{Booking_AccountType}")
    public ResponseEntity<List<customerEntity>> getCustomerByBooking_AccountType(@PathVariable String Booking_AccountType) {
        return CustomerService.getCustomerByBooking_AccountType(Booking_AccountType).map(ResponseEntity::ok).orElse(ResponseEntity.badRequest().build());
    }

    @GetMapping("/MobileNumber/{MobileNumber}")
    public ResponseEntity<customerEntity> findByCustomerMobileNumber(@PathVariable String MobileNumber) {
        return CustomerService.findByCustomerMobileNumber(MobileNumber).map(ResponseEntity::ok).orElse(ResponseEntity.badRequest().build());
    }

    @PostMapping
    public ResponseEntity<customerEntity> createCustomer(@RequestBody customerEntity customer) {
        try {
            customerEntity _createCustomer = CustomerService.createCustomer(customer);
            return ResponseEntity.ok(_createCustomer);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<customerEntity> updateCustomer(@PathVariable String id, @RequestBody customerEntity customer) {
        try {
            customerEntity _updateCustomer = CustomerService.updateCustomer(id, customer);
            return ResponseEntity.ok(_updateCustomer);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable String id) {
        CustomerService.deleteCustomer(id);
        return ResponseEntity.ok().build();
    }
}
