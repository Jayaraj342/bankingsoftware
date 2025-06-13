package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class HighDemandProduct extends BaseModel {
    @OneToOne
    private Product product;

    private int maxQuantity;
}