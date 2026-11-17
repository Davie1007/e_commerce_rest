package com.karanjadavid.e_commerce_rest.security.service;


import com.karanjadavid.e_commerce_rest.security.entity.UserPrincipal;
import com.karanjadavid.e_commerce_rest.security.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService{

    private UsersRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String entityId) throws UsernameNotFoundException {

        var usersOptional = userRepository.findByEntityId(entityId);
        if(usersOptional.isEmpty()){
            throw new UsernameNotFoundException("user not found");
        }
        var user = usersOptional.get();

        return new UserPrincipal(user);

    }

    @Autowired
    public void setUserRepository(UsersRepository repository){
        this.userRepository = repository;
    }

}
