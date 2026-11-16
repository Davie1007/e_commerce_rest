package com.karanjadavid.e_commerce_rest.manufacturer.entity;

import com.karanjadavid.e_commerce_rest.lib.entity.Address;
import com.karanjadavid.e_commerce_rest.lib.entity.BaseJpaEntity;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Manufacturer extends BaseJpaEntity {

    private String name;

    private String description;

    private Address address;

    private boolean isVerified;

}
