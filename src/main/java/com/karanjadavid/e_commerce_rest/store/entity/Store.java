package com.karanjadavid.e_commerce_rest.store.entity;

import com.karanjadavid.e_commerce_rest.lib.entity.BaseJpaEntity;
import com.karanjadavid.e_commerce_rest.storebranch.entity.StoreBranch;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Store extends BaseJpaEntity {

    private String name;

    @OneToMany
    private List<StoreBranch> branches;

}
