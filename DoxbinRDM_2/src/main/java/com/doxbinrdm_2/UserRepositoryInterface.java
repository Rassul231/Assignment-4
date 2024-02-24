package com.doxbinrdm_2;

import com.doxbinrdm_2.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepositoryInterface extends JpaRepository<User, Long> {
    Optional<User> findByLogin(String login);
}
