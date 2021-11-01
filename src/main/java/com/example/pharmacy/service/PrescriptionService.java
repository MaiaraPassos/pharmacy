package com.example.pharmacy.service;


import com.example.pharmacy.model.Prescription;
import com.example.pharmacy.repository.service.PharmacyRepository;
import com.example.pharmacy.repository.service.PrescriptionRepository;
import com.example.pharmacy.request.PrescriptionCreationRQ;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PrescriptionService {
    PrescriptionRepository prescriptionRepository;
    public PrescriptionService(PrescriptionRepository prescriptionRepository) {
        this.prescriptionRepository = prescriptionRepository;
    }

    //find all
    public List<Prescription> findAll() {
        return prescriptionRepository.findAll();
    }
    //find by id
    public Prescription getPrescriptionById(Long id){
        return  prescriptionRepository.findPrescriptionById(id);
    }
    public List<Prescription> createPrescription(List<PrescriptionCreationRQ> prescriptionCreationRQList){
        List<Prescription> newPrescriptionList = new ArrayList<>();
        Prescription newPrescription;
        for (PrescriptionCreationRQ prescriptionCreationRQ:prescriptionCreationRQList){
            newPrescription=Prescription.builder()
                    .name(prescriptionCreationRQ.getName())
                    .build();
         prescriptionRepository.save(newPrescription);
            newPrescriptionList.add(newPrescription);
        }
        return newPrescriptionList;
    }
    //update prescription
    public Prescription  updatePrescriptionById(Long id, String name) {
        Prescription prescriptionToUpdate=this.getPrescriptionById(id);
        prescriptionToUpdate.setName(name);
        prescriptionRepository.save(prescriptionToUpdate);
        return prescriptionToUpdate;
    }
    //delete by id
    public void deletePrescriptionById(Long id) {
        prescriptionRepository.deletePrescriptionById(id);
    }


}

