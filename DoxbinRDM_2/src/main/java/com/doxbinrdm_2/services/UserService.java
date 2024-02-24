package com.doxbinrdm_2.services;

import com.doxbinrdm_2.models.User;
import com.doxbinrdm_2.repositories.UserRepositoryInterface;
import com.doxbinrdm_2.services.interfaces.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService implements UserServiceInterface {

    private final UserRepositoryInterface userRepository;

    @Autowired
    public UserService(UserRepositoryInterface userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public User register(User user) {
        user.setBalance(100);
        return userRepository.save(user);
    }

    @Override
    @Transactional(readOnly = true)
    public User findById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null);
    }

    @Override
    @Transactional
    public User updateUser(Long id, User userDetails) {
        return userRepository.findById(id)
                .map(existingUser -> {
                    existingUser.setLogin(userDetails.getLogin());
                    existingUser.setPassword(userDetails.getPassword());
                    return userRepository.save(existingUser);
                }).orElse(null);
    }

    @Override
    @Transactional
    public boolean deleteUser(Long id) {
        return userRepository.findById(id)
                .map(user -> {
                    userRepository.delete(user);
                    return true;
                }).orElse(false);
    }
}
