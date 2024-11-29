package com.example.accessmysql.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.accessmysql.dao.UserRepository;
import com.example.accessmysql.model.User;


@Service
public class  UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    
    //save a user + return their details
    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }
    
    //get a user based on id
    @Override
    public Optional<User> getUserById(Integer id) {
        return userRepository.findById(id);
    }
    
    //return list of all users
    @Override
    public List<User> getAllUsers() {
        return new ArrayList<User>((Collection<? extends User>) userRepository.findAll());
    }
    
    //delete a user based on id
    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }
}