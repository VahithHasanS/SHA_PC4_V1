package com.WindowsApplication.shapc4v1.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class invoiceBillingModel {

    private Date BookingDate;

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

    public invoiceBillingModel() {
        super();
    }

    public invoiceBillingModel(Date bookingDate, String from_Name, String from_Address, String from_PinCode, String from_MobileNumber, String to_Name, String to_Address, String to_PinCode, String to_MobileNumber, int no_of_pieces, double weight, String booking_AccountType, double amount, String booking_Number, String carrier) {
        BookingDate = bookingDate;
        From_Name = from_Name;
        From_Address = from_Address;
        From_PinCode = from_PinCode;
        From_MobileNumber = from_MobileNumber;
        To_Name = to_Name;
        To_Address = to_Address;
        To_PinCode = to_PinCode;
        To_MobileNumber = to_MobileNumber;
        No_of_pieces = no_of_pieces;
        Weight = weight;
        Booking_AccountType = booking_AccountType;
        Amount = amount;
        Booking_Number = booking_Number;
        Carrier = carrier;
    }

}
