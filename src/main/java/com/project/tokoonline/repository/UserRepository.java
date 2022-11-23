package com.project.tokoonline.repository;

import com.project.tokoonline.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


   Optional <User> findByEmail(String email);
}
