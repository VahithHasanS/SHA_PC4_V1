package com.WindowsApplication.shapc4v1.controller.billing;

import com.WindowsApplication.shapc4v1.entity.billing.billingEntity;
import com.WindowsApplication.shapc4v1.service.billing.billingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/billing")
@RequiredArgsConstructor
public class billingController {
    private final billingService BillingService;

    @GetMapping
    public ResponseEntity<List<billingEntity>> getAllBill(){
        return ResponseEntity.ok(BillingService.getAllBill());
    }

    @GetMapping("/{id}")
    public ResponseEntity<billingEntity> getBillById(@PathVariable String id) {
        return BillingService.getBillById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/Booking_Number/{Booking_Number}")
    public ResponseEntity<List<billingEntity>> getBillByBooking_Number(@PathVariable String Booking_Number) {
        return BillingService.getBillByBooking_Number(Booking_Number.toUpperCase()).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/From_Name/{From_Name}")
    public ResponseEntity<List<billingEntity>> getBillByFrom_Name(@PathVariable String From_Name) {
        return BillingService.findByFrom_Name(From_Name.toUpperCase()).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/Booking_AccountType/{Booking_AccountType}")
    public ResponseEntity<List<billingEntity>> getBillByBooking_AccountType(@PathVariable String Booking_AccountType) {
        return BillingService.findByBooking_AccountType(Booking_AccountType.toUpperCase()).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/Status/{Status}")
    public ResponseEntity<List<billingEntity>> getBillByStatus(@PathVariable String Status) {
        return BillingService.findByStatus(Status.toUpperCase()).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<billingEntity> createBill(@RequestBody billingEntity bill) {
        try {
            billingEntity _createBill = BillingService.createBill(bill);
            return ResponseEntity.ok(_createBill);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<billingEntity> updateBill(@PathVariable String id, @RequestBody billingEntity bill) {
        try {
            billingEntity _updateBill = BillingService.updateBill(id, bill);
            return ResponseEntity.ok(_updateBill);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBill(@PathVariable String id) {
        BillingService.deleteBill(id);
        return ResponseEntity.ok().build();
    }
}
