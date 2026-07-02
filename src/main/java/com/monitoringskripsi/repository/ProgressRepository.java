package com.monitoringskripsi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.monitoringskripsi.entity.Progress;
import com.monitoringskripsi.entity.Skripsi;
import com.monitoringskripsi.enums.StatusProgress;

@Repository
public interface ProgressRepository extends JpaRepository<Progress, Long> {

    List<Progress> findBySkripsi(Skripsi skripsi);

    List<Progress> findByStatus(StatusProgress status);

    List<Progress> findByBabContainingIgnoreCase(String bab);

    long countByStatus(StatusProgress status);

}