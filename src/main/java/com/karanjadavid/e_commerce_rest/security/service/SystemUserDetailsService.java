package com.karanjadavid.e_commerce_rest.security.service;


import com.karanjadavid.e_commerce_rest.security.entity.SystemUserPrincipal;
import com.karanjadavid.e_commerce_rest.systemuser.repository.SystemUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SystemUserDetailsService implements UserDetailsService{

    private SystemUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        var usersOptional = userRepository.findByEmail(email);
        if(usersOptional.isEmpty()){
            throw new UsernameNotFoundException("user not found");
        }
        var user = usersOptional.get();

        return new SystemUserPrincipal(user);

    }

    @Autowired
    public void setUserRepository(SystemUserRepository repository){
        this.userRepository = repository;
    }

}
