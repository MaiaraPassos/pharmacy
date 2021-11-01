package com.example.pharmacy.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class Prescription {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private String prescription;

}
