package com.karanjadavid.e_commerce_rest.systemuser.entity;

import com.karanjadavid.e_commerce_rest.lib.entity.BaseJpaEntity;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class SystemUser extends BaseJpaEntity {
    private String name;
    private String phoneNumber;
    private String email;
    private String password;
}
