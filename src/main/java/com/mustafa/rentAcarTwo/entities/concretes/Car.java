package com.mustafa.rentAcarTwo.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cars")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String plate;

    private int dailyPrice;

    private int modelYear;

    private int state;

    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model;

}
