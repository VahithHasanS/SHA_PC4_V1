package com.WindowsApplication.shapc4v1.controller.invoice;

import com.WindowsApplication.shapc4v1.entity.invoice.invoiceEntity;
import com.WindowsApplication.shapc4v1.service.invoice.invoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/invoice")
@RequiredArgsConstructor
public class invoiceController {
    private final invoiceService InvoiceService;

    @GetMapping
    public ResponseEntity<List<invoiceEntity>> getAllInvoice() {
        return ResponseEntity.ok(InvoiceService.findAllInvoice());
    }

    @GetMapping("/Name/{Name}")
    public ResponseEntity<List<invoiceEntity>> getByName(@PathVariable String Name) {
        return InvoiceService.findByName(Name).map(ResponseEntity::ok).orElse(ResponseEntity.badRequest().build());
    }

    @PostMapping
    public ResponseEntity<invoiceEntity> createInvoice(@RequestBody invoiceEntity invoice) {
        try {
            invoiceEntity _createInvoice = InvoiceService.createInvoice(invoice);
            return ResponseEntity.ok(_createInvoice);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<invoiceEntity> updateInvoice(@PathVariable String id, @RequestBody invoiceEntity invoice) {
        try {
            invoiceEntity updateInvoice = InvoiceService.updateInvoice(id, invoice);
            return ResponseEntity.ok(updateInvoice);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInvoice(@PathVariable String id) {
        InvoiceService.deleteInvoice(id);
        return ResponseEntity.ok().build();
    }
}
