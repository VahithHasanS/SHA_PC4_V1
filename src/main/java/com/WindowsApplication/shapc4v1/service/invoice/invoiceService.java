package com.WindowsApplication.shapc4v1.service.invoice;

import com.WindowsApplication.shapc4v1.entity.invoice.invoiceEntity;
import com.WindowsApplication.shapc4v1.repository.invoice.invoiceRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class invoiceService {
    private final invoiceRepo InvoiceRepo;

    public List<invoiceEntity> findAllInvoice() {
        return InvoiceRepo.findAll();
    }

    public Optional<List<invoiceEntity>> findByName(String Name) {
        return InvoiceRepo.findByName(Name);
    }

    public invoiceEntity createInvoice(invoiceEntity invoice) {
        return InvoiceRepo.save(invoice);
    }

    public invoiceEntity updateInvoice(String id, invoiceEntity invoiceDetail) {
        return InvoiceRepo.findById(id).map(
                invoice ->{
                    invoice.setInvoiceStatus(invoiceDetail.getInvoiceStatus());
                    invoice.setUpload_on_Online(invoiceDetail.isUpload_on_Online());
                    return InvoiceRepo.save(invoice);
                }
        ).orElseThrow(() -> new ArithmeticException("Invoice not found with id: " + id));
    }

    public void deleteInvoice(String id) {
        InvoiceRepo.deleteById(id);
    }
}
