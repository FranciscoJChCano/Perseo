package Proyect.Perseo.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import Proyect.Perseo.repositories.IUserRepository;

import java.util.ArrayList;

public class UserService {


    @Autowired
    IUserRepository iUserRepository;

    public ArrayList<User> getUsers(){
        return (ArrayList<User>) iUserRepository.findAll();
    }

    public User getUserById(Long id){
        User user;
        user = iUserRepository.findById(id).orElseThrow();
        return user;

    }

    public User addUser(User user ){
        return iUserRepository.save(user);
    }

    public void updateUser(User user){
        iUserRepository.save(user);
    }

    public String deleteUser(Long id){
        try{
            iUserRepository.deleteById(id);
            return "ok";
        }catch (Exception error){
            return "failed to create user";
        }
    }

}
