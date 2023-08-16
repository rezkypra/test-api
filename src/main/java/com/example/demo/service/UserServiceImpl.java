package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.Login;
import com.example.demo.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Login> Get() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Login Get(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Boolean Save(Login model) {
        userRepository.save(model);
        return userRepository.findById(model.getId()).isPresent();
    }

    @Override
    public Boolean Delete(Integer id) {
        // TODO Auto-generated method stub
        return true;
    }
}
