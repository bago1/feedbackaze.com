package com.feedback.website.services;

import com.feedback.website.models.User;
import com.feedback.website.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public void saveUser(User user) {
        userRepo.save(user);
    }

    public void updateUser(Integer id) {
    }

    public Optional<User> getById(Integer id) {
        return  userRepo.findById(id);
    }

    public List<User> getAllUsers() {
return userRepo.findAll();
    }

    public void deleteUser(User user
    ) {
        userRepo.delete(user);
    }
}
