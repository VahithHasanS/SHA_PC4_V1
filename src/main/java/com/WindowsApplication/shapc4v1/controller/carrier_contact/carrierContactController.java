package com.WindowsApplication.shapc4v1.controller.carrier_contact;

import com.WindowsApplication.shapc4v1.entity.carrier_contact.carrierContactEntity;
import com.WindowsApplication.shapc4v1.service.carrier_contact.carrierContactService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/carrier")
@RequiredArgsConstructor
public class carrierContactController {
    private final carrierContactService CarrierContactService;

    @GetMapping
    public ResponseEntity<List<carrierContactEntity>> getAllCarrier() {
        return ResponseEntity.ok(CarrierContactService.findAllCarrier());
    }

    @GetMapping("/Name/{Name}")
    public ResponseEntity<List<carrierContactEntity>> getByName(@PathVariable String Name) {
        return CarrierContactService.findByName(Name).map(ResponseEntity::ok).orElse(ResponseEntity.badRequest().build());
    }

    @GetMapping("/PinCode/{PinCode}")
    public ResponseEntity<carrierContactEntity> getByPinCode(@PathVariable String PinCode) {
        return CarrierContactService.findByPinCode(PinCode).map(ResponseEntity::ok).orElse(ResponseEntity.badRequest().build());
    }

    @PostMapping
    public ResponseEntity<carrierContactEntity> createCarrier(@RequestBody carrierContactEntity carrier) {
        try {
            carrierContactEntity _createCarrier = CarrierContactService.createCarrier(carrier);
            return ResponseEntity.ok(_createCarrier);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<carrierContactEntity> updateCarrier(@PathVariable String id, @RequestBody carrierContactEntity carrier) {
        try {
            carrierContactEntity _updateCarrier = CarrierContactService.updateCarrier(id, carrier);
            return ResponseEntity.ok(_updateCarrier);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCarrier(@PathVariable String id) {
        CarrierContactService.deleteCarrier(id);
        return ResponseEntity.ok().build();
    }
}
