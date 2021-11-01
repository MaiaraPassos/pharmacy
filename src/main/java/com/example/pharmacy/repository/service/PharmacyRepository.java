package com.example.pharmacy.repository.service;

import com.example.pharmacy.model.Pharmacy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PharmacyRepository extends JpaRepository<Pharmacy, Long> {
    Pharmacy findPharmacyById(Long id);
    void deletePharmacyById(Long id);
}
