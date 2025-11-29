package com.WindowsApplication.shapc4v1.service.billing;

import com.WindowsApplication.shapc4v1.entity.billing.billingEntity;
import com.WindowsApplication.shapc4v1.repository.billing.billingRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class billingService {
    private final billingRepo BillingRepo;

    public List<billingEntity> getAllBill() {
        return BillingRepo.findAll();
    }

    public Optional<billingEntity> getBillById(String id) {
        return BillingRepo.findById(id);
    }

    public Optional<List<billingEntity>> getBillByBooking_Number(String Booking_Number) {
        return BillingRepo.findByBookingNumber(Booking_Number);
    }

    public Optional<List<billingEntity>> findByFrom_Name(String From_Name) {
        return BillingRepo.findByFrom_Name(From_Name);
    }

    public Optional<List<billingEntity>> findByStatus(String Status) {
        return BillingRepo.findByStatus(Status);
    }

    public Optional<List<billingEntity>> findByBooking_AccountType(String Booking_AccountType) {
        return BillingRepo.findByBooking_AccountType(Booking_AccountType);
    }

    public billingEntity createBill(billingEntity bill) {
        if (BillingRepo.existBooking_Number(bill.getBooking_Number()).toString().equals(bill.getBooking_Number().toUpperCase())){
            throw new RuntimeException("Bill with Bill number: " + bill.getBooking_Number() + " is already existed");
        } else {
            return BillingRepo.save(bill);
        }
    }

    public billingEntity updateBill(String id, billingEntity billDetails) {
        return BillingRepo.findById(id).map(bill -> {
            bill.setFrom_Name(billDetails.getFrom_Name());
            bill.setFrom_Address(billDetails.getFrom_Address());
            bill.setFrom_MobileNumber(billDetails.getFrom_MobileNumber());
            bill.setFrom_PinCode(billDetails.getFrom_PinCode());
            bill.setTo_Name(billDetails.getTo_Name());
            bill.setTo_Address(billDetails.getTo_Address());
            bill.setTo_MobileNumber(billDetails.getTo_MobileNumber());
            bill.setTo_PinCode(billDetails.getTo_PinCode());
            bill.setAmount(billDetails.getAmount());
            bill.setBooking_AccountType(billDetails.getBooking_AccountType());
            bill.setBookingDate(billDetails.getBookingDate());
            bill.setBooking_Number(billDetails.getBooking_Number());
            bill.setCarrier(billDetails.getCarrier());
            bill.setWeight(billDetails.getWeight());
            bill.setNo_of_pieces(billDetails.getNo_of_pieces());
            bill.setUpload_on_Online(billDetails.isUpload_on_Online());
            return BillingRepo.save(bill);
        }).orElseThrow(() -> new RuntimeException("Bill not found with id: " + id));
    }

    public void deleteBill(String id) {
        BillingRepo.deleteById(id);
    }
}
