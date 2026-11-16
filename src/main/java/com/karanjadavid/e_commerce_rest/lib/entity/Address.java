package com.karanjadavid.e_commerce_rest.lib.entity;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class Address {

    private String instructions;

    private String longitude;

    private String latitude;

}
