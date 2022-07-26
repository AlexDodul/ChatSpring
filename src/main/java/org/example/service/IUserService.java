package org.example.service;


import org.example.entity.User;
import org.springframework.transaction.annotation.Transactional;

public interface IUserService {
    @Transactional
    User createUser(User user);

    @Transactional(readOnly = true)
    User getByName(String name);
}
