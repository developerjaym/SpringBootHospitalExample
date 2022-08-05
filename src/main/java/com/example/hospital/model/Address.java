package com.example.hospital.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@Setter
@ToString
public class Address {
    private String line1;
    private String line2;
    private String line3;
    private String city;
    private String region;
    private String country;
}
