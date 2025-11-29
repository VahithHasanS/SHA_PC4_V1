package com.WindowsApplication.shapc4v1.entity.billing;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Document(collection = "billing")
public class billingEntity {

    @Id
    private String id;

    private LocalDate BookingDate;

    private String From_Name;
    private String From_Address;
    private String From_PinCode;
    private String From_MobileNumber;

    private String To_Name;
    private String To_Address;
    private String To_PinCode;
    private String To_MobileNumber;

    private int No_of_pieces;
    private double Weight;
    private String Booking_AccountType;
    private double Amount;

    private String Booking_Number;
    private String Carrier;

    private String Status;
    private String Delivered_Date;

    private LocalDate createdAt;
    private boolean isUpload_on_Online;

    public billingEntity(LocalDate BookingDate, String From_Name, String From_Address, String From_PinCode, String From_MobileNumber, String To_Name, String To_Address, String To_PinCode, String To_MobileNumber, int No_of_pieces, double Weight, String Booking_AccountType, double Amount, String Booking_Number, String Carrier, boolean isUpload_on_Online, String Status, String Delivered_Date) {
        this();
        this.BookingDate = BookingDate;
        this.From_Name = From_Name;
        this.From_Address = From_Address;
        this.From_PinCode = From_PinCode;
        this.From_MobileNumber = From_MobileNumber;
        this.To_Name = To_Name;
        this.To_Address = To_Address;
        this.To_PinCode = To_PinCode;
        this.To_MobileNumber = To_MobileNumber;
        this.No_of_pieces = No_of_pieces;
        this.Weight = Weight;
        this.Booking_AccountType = Booking_AccountType;
        this.Amount = Amount;
        this.Booking_Number = Booking_Number;
        this.Carrier = Carrier;
        this.Status = Status;
        this.Delivered_Date = Delivered_Date;
        this.isUpload_on_Online = isUpload_on_Online;
    }

    public billingEntity() {
        this.createdAt = LocalDate.now();
    }
}
