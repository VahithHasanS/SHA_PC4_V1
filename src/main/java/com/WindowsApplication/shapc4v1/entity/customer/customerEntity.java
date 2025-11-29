package com.WindowsApplication.shapc4v1.entity.customer;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Document(collection = "customer")
public class customerEntity {

    @Id
    private String id;

    private String Name;
    private String Address;
    private String PinCode;
    private String MobileNumber;
    private String Booking_AccountType;
    private String Remarks;

    private LocalDate createdAt;
    private boolean isUpload_on_Online;

    public customerEntity() {
        this.createdAt = LocalDate.now();
    }

    public customerEntity(String Name, String Address, String PinCode, String MobileNumber, String Booking_AccountType, String Remarks, boolean isUpload_on_Online) {
        this();
        this.Name = Name;
        this.Address = Address;
        this.PinCode = PinCode;
        this.MobileNumber = MobileNumber;
        this.Booking_AccountType = Booking_AccountType;
        this.Remarks = Remarks;
        this.isUpload_on_Online = isUpload_on_Online;
    }
}
