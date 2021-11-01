package com.example.pharmacy.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class Client  {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @OneToMany(mappedBy = "client")
    private List<Medicine> client;

    @ManyToOne
    @JoinColumn(name = "pharmacy_id", nullable = false)
    private Pharmacy pharmacy;

    @ManyToMany
    private List<Client> clientMedicine;

}
