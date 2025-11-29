package com.WindowsApplication.shapc4v1.service.customer;

import com.WindowsApplication.shapc4v1.entity.customer.customerEntity;
import com.WindowsApplication.shapc4v1.repository.customer.customerRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class customerService {
    private final customerRepo CustomerRepo;

    public List<customerEntity> getAllCustomer() {
        return CustomerRepo.findAll();
    }

    public Optional<List<customerEntity>> getCustomerByName(String Name) {
        return CustomerRepo.findByName(Name);
    }

    public Optional<List<customerEntity>> getCustomerByBooking_AccountType(String Booking_AccountType) {
        return CustomerRepo.findByBooking_AccountType(Booking_AccountType);
    }

    public Optional<customerEntity> findByCustomerMobileNumber(String MobileNumber) {
        return CustomerRepo.findByMobileNumber(MobileNumber);
    }

    public customerEntity createCustomer(customerEntity customer) {
        if (CustomerRepo.existCustomer(customer.getName()).toString().equals(customer.getName())){
            throw new RuntimeException("Customer with this name: " + customer.getName() + " is already existed");
        }
        return CustomerRepo.save(customer);
    }

    public customerEntity updateCustomer(String id, customerEntity customerDetails) {
        return CustomerRepo.findById(id).map(
                customer -> {
                    customer.setName(customerDetails.getName());
                    customer.setAddress(customerDetails.getAddress());
                    customer.setMobileNumber(customerDetails.getMobileNumber());
                    customer.setPinCode(customerDetails.getPinCode());
                    customer.setBooking_AccountType(customerDetails.getBooking_AccountType());
                    customer.setRemarks(customerDetails.getRemarks());
                    customer.setUpload_on_Online(customerDetails.isUpload_on_Online());
                    return CustomerRepo.save(customer);
                }
        ).orElseThrow(() -> new RuntimeException("Customer not found wit id: " + id));
    }

    public void deleteCustomer(String id) {
        CustomerRepo.deleteById(id);
    }
}
