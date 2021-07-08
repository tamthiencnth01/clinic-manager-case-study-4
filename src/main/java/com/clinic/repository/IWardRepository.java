package com.clinic.repository;

import com.clinic.model.Ward;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IWardRepository extends JpaRepository<Ward, Long> {
}
