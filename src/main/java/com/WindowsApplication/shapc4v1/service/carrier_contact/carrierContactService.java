package com.WindowsApplication.shapc4v1.service.carrier_contact;

import com.WindowsApplication.shapc4v1.entity.carrier_contact.carrierContactEntity;
import com.WindowsApplication.shapc4v1.repository.carrier_contact.carrierContactRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class carrierContactService {
    private final carrierContactRepo CarrierContactRepo;

    public List<carrierContactEntity> findAllCarrier() {
        return CarrierContactRepo.findAll();
    }

    public Optional<List<carrierContactEntity>> findByName(String Name) {
        return CarrierContactRepo.findByName(Name);
    }

    public Optional<carrierContactEntity> findByPinCode(String PinCode) {
        return CarrierContactRepo.findByPinCode(PinCode);
    }

    public carrierContactEntity createCarrier(carrierContactEntity carrier) {
        if (CarrierContactRepo.existPinCode(carrier.getPinCode()).toString().equals(carrier.getPinCode())) {
            throw new RuntimeException("Carrier with pincode: " + carrier.getPinCode() + " is already existed");
        }
        return CarrierContactRepo.save(carrier);
    }

    public carrierContactEntity updateCarrier(String id, carrierContactEntity carrierDetail) {
        return CarrierContactRepo.findById(id).map(
                carrier -> {
                    carrier.setCarrier(carrierDetail.getCarrier());
                    carrier.setName(carrierDetail.getName());
                    carrier.setAddress(carrierDetail.getAddress());
                    carrier.setPinCode(carrierDetail.getPinCode());
                    carrier.setContact_1(carrierDetail.getContact_1());
                    carrier.setContact_2(carrierDetail.getContact_2());
                    carrier.setUpload_on_Online(carrierDetail.isUpload_on_Online());
                    return CarrierContactRepo.save(carrier);
                }
        ).orElseThrow(() -> new RuntimeException("Carrier not found with id: " + id));
    }

    public void deleteCarrier(String id) {
        CarrierContactRepo.deleteById(id);
    }
}
