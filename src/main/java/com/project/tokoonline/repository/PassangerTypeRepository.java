package com.project.tokoonline.repository;

import com.project.tokoonline.model.PassangerType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassangerTypeRepository extends JpaRepository<PassangerType, Long> {

}
