package com.example.pharmacy.service;

import com.example.pharmacy.model.Pharmacy;
import com.example.pharmacy.repository.service.PharmacyRepository;
import com.example.pharmacy.request.PharmacyCreationRQ;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PharmacyService {
    PharmacyRepository pharmacyRepository;

    public PharmacyService(PharmacyRepository pharmacyRepository) {
        this.pharmacyRepository = pharmacyRepository;
    }

    //find all
    public List<Pharmacy> findAll() {
        return pharmacyRepository.findAll();
    }

    //find by id
    public Pharmacy getPharmacyById(Long id) {
        return pharmacyRepository.findPharmacyById(id);
    }

    public List<Pharmacy> createPharmacy(List<PharmacyCreationRQ> pharmacyCreationRQList) {
        List<Pharmacy> newPharmacyList = new ArrayList<>();
        Pharmacy newPharmacy;
        for (PharmacyCreationRQ pharmacyCreationRequest : pharmacyCreationRQList) {
            newPharmacy = Pharmacy.builder()
                    .name(pharmacyCreationRequest.getName())
                    .build();
            pharmacyRepository.save(newPharmacy);
            newPharmacyList.add(newPharmacy);
        }
        return newPharmacyList;
    }

    //update pharmacy
    public Pharmacy updatePharmacyById(Long id, String name) {
        Pharmacy pharmacyToUpdate = this.getPharmacyById(id);
        pharmacyToUpdate.setName(name);
        pharmacyRepository.save(pharmacyToUpdate);
        return pharmacyToUpdate;
    }
    //delete by id
    public void deletePharmacyById(Long id) {
        pharmacyRepository.deletePharmacyById(id);
    }
    public Pharmacy addPet(Pharmacy build) {
        return build;
    }

    public Pharmacy update(
            PharmacyCreationRQ pharmacyCreationRQ, Long id) {
        return null;
    }
}

