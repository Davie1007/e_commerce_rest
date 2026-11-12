package com.karanjadavid.e_commerce_rest.customer.entity;

import com.karanjadavid.e_commerce_rest.lib.entity.BaseJpaEntity;
import com.karanjadavid.e_commerce_rest.systemuser.entity.SystemUser;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Customer extends SystemUser {


}
