package com.example.pharmacy.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ClientCreationRQ {
    private String medicine;
    private String prescription;
    private String name;

}
