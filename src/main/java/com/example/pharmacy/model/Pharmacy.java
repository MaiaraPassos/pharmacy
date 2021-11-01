package com.example.pharmacy.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class Pharmacy {
  //each store can have many clients
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "pharmacy")
    private List<Client> clientList;

}

