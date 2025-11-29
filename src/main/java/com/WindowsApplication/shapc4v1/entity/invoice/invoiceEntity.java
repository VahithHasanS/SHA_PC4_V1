package com.WindowsApplication.shapc4v1.entity.invoice;

import com.WindowsApplication.shapc4v1.model.invoiceBillingModel;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Data
@Document(collection = "invoice")
public class invoiceEntity {

    @Id
    private String id;

    private String Name;
    private List<invoiceBillingModel> Billing;
    private int TotalBillCount;
    private int TotalPieces;
    private double TotalAmount;
    private String InvoiceCode;
    private String InvoiceStatus;

    private LocalDate createdAt;
    private boolean isUpload_on_Online;

    public invoiceEntity() {
        this.createdAt = LocalDate.now();
    }

    public invoiceEntity(String Name, List<invoiceBillingModel> Billing, int TotalBillCount, int TotalPieces, double TotalAmount, String InvoiceCode, String InvoiceStatus, boolean isUpload_on_Online) {
        this();
        this.Name = Name;
        this.Billing = Billing;
        this.TotalBillCount = TotalBillCount;
        this.TotalPieces = TotalPieces;
        this.TotalAmount = TotalAmount;
        this.InvoiceCode = InvoiceCode;
        this.InvoiceStatus = InvoiceStatus;
        this.isUpload_on_Online = isUpload_on_Online;
    }
}
