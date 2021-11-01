package com.example.pharmacy.controller;


import com.example.pharmacy.model.Client;
import com.example.pharmacy.request.ClientCreationRQ;
import com.example.pharmacy.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Validated
public class ClientController {
    @Autowired
    ClientService clientService;
    @GetMapping("/client/{id}")
    public Client getClientById(@PathVariable Long id) {
        Client client = clientService.getClientById(id);
        return clientService.getClientById(id);
    }
    @PostMapping("/client{id}")
    public List<Client> createClient(@RequestBody List<ClientCreationRQ>clientCreationRQS){
        return clientService.createClient(clientCreationRQS);
    }

    @PutMapping(value = "/client-update{id}")
    public Client updateClientName(@PathVariable(value = "id")Long id,@RequestBody UpdateClientNameRQ updateClientNameRQ){
        return  clientService.updateClientById(id, updateClientNameRQ.getName());
    }
    @DeleteMapping(value = "/client-delete{id}")
    public void deleteById(@PathVariable(value = "id")Long id){clientService.deleteClientById(id);}
}
