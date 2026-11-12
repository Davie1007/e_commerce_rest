package com.karanjadavid.e_commerce_rest.storebranch.entity;

import com.karanjadavid.e_commerce_rest.inventory.entity.Inventory;
import com.karanjadavid.e_commerce_rest.lib.entity.BaseJpaEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class StoreBranch extends BaseJpaEntity {

    private String name;

    @OneToMany
    private List<Inventory> inventories;

}
