package com.example.pharmacy.controller;


import com.example.pharmacy.model.Client;
import com.example.pharmacy.model.Medicine;
import com.example.pharmacy.model.Prescription;
import com.example.pharmacy.request.MedicineCreationRQ;
import com.example.pharmacy.request.PrescriptionCreationRQ;
import com.example.pharmacy.response.MedicineReturnResponse;
import com.example.pharmacy.service.MedicineService;
import com.example.pharmacy.service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@Validated
public class MedicineController {
    @Autowired
    MedicineService medicineService;

    @GetMapping("/medicines")
    public List<Medicine> getMedicineById(){
        return medicineService.findAll();
    }

    @PostMapping("/medicines{id}")
    public List<Medicine> createMedicine(@RequestBody List<MedicineCreationRQ>medicineCreationRQS){
        return medicineService.createMedicine(medicineCreationRQS);
    }

    @PutMapping(value = "/medicine-update{id}")
    public Medicine updateMedicineName(@PathVariable(value = "id")Long id,@RequestBody UpdateMedicineNameRQ updateMedicineNameRQ){
        return  medicineService.updateMedicineById(id, updateMedicineNameRQ.getName());
    }
    @DeleteMapping(value = "/medicine-delete{id}")
    public void deleteById(@PathVariable(value = "id")Long id){medicineService.deleteMedicineById(id);}
}

