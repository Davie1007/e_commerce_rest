package com.karanjadavid.e_commerce_rest.systemuser.entity;

import com.karanjadavid.e_commerce_rest.lib.entity.BaseJpaEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "user_type")
public class SystemUser extends BaseJpaEntity {
    @Column(unique = true)
    private String email;
    private String password;
    private String name;
    private String phoneNumber;
}
