package com.example.pharmacy.model;

import lombok.*;

import javax.persistence.*;
import java.nio.file.attribute.AttributeView;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@ToString
@Table(name= "Medicine")
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String Name;
    private String prescription;
    @ManyToOne
    private Client client;

    @ManyToMany
    @JoinTable(name = "medicine_client",
            joinColumns = @JoinColumn(name = "medicine-id"),
            inverseJoinColumns = @JoinColumn(name = "client_id")
    )
    private Set<Client> clientMedicines = new HashSet<>();

}
