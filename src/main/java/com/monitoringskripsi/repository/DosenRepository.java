package com.monitoringskripsi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.monitoringskripsi.model.Dosen;

@Repository
public interface DosenRepository extends JpaRepository<Dosen, Long> {

}