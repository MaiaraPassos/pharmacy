package com.example.pharmacy.controller;

import com.example.pharmacy.model.Prescription;
import com.example.pharmacy.request.PharmacyCreationRQ;
import com.example.pharmacy.request.PrescriptionCreationRQ;
import com.example.pharmacy.service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Validated

public class PrescriptionController {
    @Autowired
    PrescriptionService prescriptionService;
    @GetMapping("/prescriptions/{id}")
    public Prescription getPrescriptionById(@PathVariable Long id) {
       Prescription prescription = prescriptionService.getPrescriptionById(id);
       return prescriptionService.getPrescriptionById(id);
    }
    @PostMapping("/prescriptions{id}")
    public List<Prescription> createPrescription(@RequestBody List<PrescriptionCreationRQ>prescriptionCreationRQS){
        return prescriptionService.createPrescription(prescriptionCreationRQS);
    }

    @PutMapping(value = "/prescriptions-update{id}")
    public Prescription updatePrescriptionName(@PathVariable(value = "id")Long id,@RequestBody UpdatePrescriptionNameRQ updatePrescriptionNameRQ){
    return  prescriptionService.updatePrescriptionById(id, updatePrescriptionNameRQ.getName());
    }
    @DeleteMapping(value = "/prescription-delete{id}")
    public void deleteById(@PathVariable(value = "id")Long id){prescriptionService.deletePrescriptionById(id);}
}
