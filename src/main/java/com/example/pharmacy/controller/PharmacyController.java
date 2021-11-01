package com.example.pharmacy.controller;



import com.example.pharmacy.model.Pharmacy;
import com.example.pharmacy.request.PharmacyCreationRQ;
import com.example.pharmacy.service.PharmacyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Validated


public class PharmacyController {
    @Autowired
    PharmacyService pharmacyService;
    @GetMapping("/pharmacy/{id}")
    public Pharmacy getPharmacyById(@PathVariable Long id) {
        Pharmacy pharmacy = pharmacyService.getPharmacyById(id);
        return pharmacyService.getPharmacyById(id);
    }
    @PostMapping("/pharmacy{id}")
    public List<Pharmacy> createPharmacy(@RequestBody List<PharmacyCreationRQ>pharmacyCreationRQS){
        return pharmacyService.createPharmacy(pharmacyCreationRQS);
    }

    @PutMapping(value = "/pharmacy-update{id}")
    public Pharmacy updatePharmacyName(@PathVariable(value = "id")Long id,@RequestBody UpdatePharmacyNameRQ updatePharmacyNameRQ){
        return  pharmacyService.updatePharmacyById(id, updatePharmacyNameRQ.getName());
    }
    @DeleteMapping(value = "/pharmacy-delete{id}")
    public void deleteById(@PathVariable(value = "id")Long id){pharmacyService.deletePharmacyById(id);}
}
