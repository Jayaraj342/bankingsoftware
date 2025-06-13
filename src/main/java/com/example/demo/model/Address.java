package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Address extends BaseModel {
    @ManyToOne
    private User user;

    private String building;
    private int floor;
    private String city;
    private String state;
    private String country;

    @Column(name = "zip_code")
    private String zipCode;
}