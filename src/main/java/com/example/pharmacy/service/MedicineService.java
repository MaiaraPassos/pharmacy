package com.example.pharmacy.service;

import com.example.pharmacy.model.Medicine;
import com.example.pharmacy.repository.service.MedicineRepository;
import com.example.pharmacy.request.MedicineCreationRQ;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MedicineService {
    MedicineRepository medicineRepository;

    public MedicineService(MedicineRepository medicineRepository) {
        this.medicineRepository = medicineRepository;
    }

    //find all
    public List<Medicine> findAll() {
        return medicineRepository.findAll();
    }

    //find by id
    public Medicine getMedicineById(Long id) {
        return medicineRepository.findMedicineById(id);
    }

    public List<Medicine> createMedicine(List<MedicineCreationRQ> medicineCreationRQList) {
        List<Medicine> newMedicineList = new ArrayList<>();
        Medicine newMedicine;
        for (MedicineCreationRQ medicineCreationRQ : medicineCreationRQList) {
            newMedicine = Medicine.builder()
                    .Name(medicineCreationRQ.getName())
                    .build();
            medicineRepository.save(newMedicine);
            newMedicineList.add(newMedicine);
        }
        return newMedicineList;
    }

    //update medicine
    public Medicine updateMedicineById(Long id, String name) {
        Medicine medicineToUpdate = this.getMedicineById(id);
        medicineToUpdate.setName(name);
        medicineRepository.save(medicineToUpdate);
        return medicineToUpdate;
    }

    //delete by id
    public void deleteMedicineById(Long id) {
        medicineRepository.deleteMedicineById(id);
    }
    public Medicine update(MedicineCreationRQ medicineCreationRQ, Long id) {
        return null;
    }


}
