package com.WindowsApplication.shapc4v1.entity.delivery_status;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Date;

@Data
@Document(collection = "deliveryStatus")
public class deliveryStatusEntity {

    @Id
    private String id;

    private String Status;
    private Date Delivered_Date;
    private String From_Name;
    private String To_Name;
    private String Booking_Number;

    private LocalDate createdAt;
    private boolean isUpload_on_Online;

    public deliveryStatusEntity() {
        this.createdAt = LocalDate.now();
    }

    public deliveryStatusEntity(String Status, Date Delivered_Date, String From_Name, String To_Name, String Booking_Number, boolean isUpload_on_Online) {
        this();
        this.Status =Status;
        this.Delivered_Date = Delivered_Date;
        this.From_Name = From_Name;
        this.To_Name = To_Name;
        this.Booking_Number = Booking_Number;
        this.isUpload_on_Online = isUpload_on_Online;
    }
}
