package com.karanjadavid.e_commerce_rest.systemuser.repository;

import com.karanjadavid.e_commerce_rest.lib.repository.BaseJpaRepository;
import com.karanjadavid.e_commerce_rest.systemuser.entity.SystemUser;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SystemUserRepository extends BaseJpaRepository<SystemUser> {

    Optional<SystemUser> findByEmail(String email);

}
