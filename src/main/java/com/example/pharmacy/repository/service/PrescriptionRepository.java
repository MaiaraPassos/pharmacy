package com.example.pharmacy.repository.service;

import com.example.pharmacy.model.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {
    Prescription findPrescriptionById(Long id);
    void deletePrescriptionById(Long id);
}
