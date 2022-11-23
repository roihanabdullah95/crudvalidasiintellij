package com.project.tokoonline.repository;


import com.project.tokoonline.model.Tugas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TugasRepository extends JpaRepository<Tugas, Long> {
    Optional<Tugas> findByEmail(String email);
}
