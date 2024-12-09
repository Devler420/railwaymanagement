package com.boompanupong.railwaymanagement.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "passenger")
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "citizen_id")
    private String citizenId;

    @Column(name = "birth_date")
    private String birthDate;

    @Column(name = "mobile_no")
    private String mobileNo;
}