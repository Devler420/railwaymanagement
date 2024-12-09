package com.boompanupong.railwaymanagement.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "station")
public class Station {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "station_name")
    private String stationName;

    @Column(name = "location")
    private String location;

    @Column(name = "contact_information")
    private String contactInformation;
}
