package com.example.aeon.repository;

import com.example.aeon.entity.KaryawanTraining;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KaryawanTrainingRepository extends JpaRepository<KaryawanTraining,Long> {
}
