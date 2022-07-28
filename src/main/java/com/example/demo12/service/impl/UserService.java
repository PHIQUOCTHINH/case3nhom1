package com.example.demo12.service.impl;

import com.example.demo12.DAO.UserRepository;
import com.example.demo12.model.User;
import com.example.demo12.service.ICRUDService;

import java.util.ArrayList;

public class UserService implements ICRUDService<User> {
    UserRepository userRepository = new UserRepository();
    @Override
    public User findById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public ArrayList<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void create(User user) {
        userRepository.create(user);
    }

    @Override
    public void update(User user) {
        userRepository.update(user);
    }

    @Override
    public void deleteById(int id) {
        userRepository.deleteById(id);
    }
    public User findByEmail(String email){
        return   userRepository.findByEmail(email);
    }
}
