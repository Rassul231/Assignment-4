package com.doxbinrdm_2.repositories;

import com.doxbinrdm_2.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface UserServiceInterface extends JpaRepository<User, Long> {
    @Transactional
    User register(User user);

    Optional<User> findByLogin(String login);
}
