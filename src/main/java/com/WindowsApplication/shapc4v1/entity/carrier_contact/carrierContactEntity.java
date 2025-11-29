package com.WindowsApplication.shapc4v1.entity.carrier_contact;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Document(collection = "carrierContact")
public class carrierContactEntity {

    @Id
    private String id;

    private String Name;
    private String Address;
    private String PinCode;
    private String Carrier;
    private String Contact_1;
    private String Contact_2;

    private LocalDate createdAt;
    private boolean isUpload_on_Online;

    public carrierContactEntity() {
        this.createdAt = LocalDate.now();
    }

    public carrierContactEntity(String Name, String Address, String PinCode, String Carrier, String Contact_1, String Contact_2, boolean isUpload_on_Online) {
        this();
        this.Name = Name;
        this.Address = Address;
        this.PinCode = PinCode;
        this.Carrier = Carrier;
        this.Contact_1 = Contact_1;
        this.Contact_2 = Contact_2;
        this.isUpload_on_Online = isUpload_on_Online;
    }
}
