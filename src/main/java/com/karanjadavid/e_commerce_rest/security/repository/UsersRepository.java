package com.karanjadavid.e_commerce_rest.security.repository;

import com.karanjadavid.e_commerce_rest.lib.repository.BaseJpaRepository;
import com.karanjadavid.e_commerce_rest.security.entity.Users;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends BaseJpaRepository<Users> {
}
