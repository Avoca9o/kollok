package com.example.kollok.api.models;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Order {
    @Id
    private Long id;

    public Order() {
    }


}
