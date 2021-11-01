package com.example.pharmacy.repository.service;


import com.example.pharmacy.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository  extends JpaRepository<Client, Long> {
    Client findClientById(Long id);
    void deleteClientById(Long id);
}
