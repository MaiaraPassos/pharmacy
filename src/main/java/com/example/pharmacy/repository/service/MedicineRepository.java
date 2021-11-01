package com.example.pharmacy.repository.service;

import com.example.pharmacy.model.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicineRepository extends JpaRepository <Medicine, Long> {
    Medicine findMedicineById(Long id);
    void deleteMedicineById(Long id);
}
