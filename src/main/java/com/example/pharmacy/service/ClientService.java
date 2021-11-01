package com.example.pharmacy.service;


import com.example.pharmacy.model.Client;
import com.example.pharmacy.repository.service.ClientRepository;
import com.example.pharmacy.request.ClientCreationRQ;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ClientService {
    ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    //find all
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    //find by id
    public Client getClientById(Long id) {
        return clientRepository.findClientById(id);
    }

    public List<Client> createClient(List<ClientCreationRQ> clientCreationRQList) {
        List<Client> newClientList = new ArrayList<>();
        Client newClient;
        for (ClientCreationRQ clientCreationRequest : clientCreationRQList) {
            newClient = Client.builder()
                    .name(clientCreationRequest.getName())
                    .build();
            clientRepository.save(newClient);
            newClientList.add(newClient);
        }
        return newClientList;
    }

    //update pharmacy
    public Client updateClientById(Long id, String name) {
        Client clientToUpdate = this.getClientById(id);
        clientToUpdate.setName(name);
        clientRepository.save(clientToUpdate);
        return clientToUpdate;
    }

    //delete by id
    public void deleteClientById(Long id) {
        clientRepository.deleteClientById(id);
    }

}

