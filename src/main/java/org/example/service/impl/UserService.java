package org.example.service.impl;

import org.example.entity.User;
import org.example.repository.UserRepo;
import org.example.service.IUserService;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User createUser(User user) {
        return userRepo.save(user);
    }

    public User getByName(String name) {
        return userRepo.getByName(name);
    }
}
