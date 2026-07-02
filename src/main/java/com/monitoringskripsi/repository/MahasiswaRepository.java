package com.monitoringskripsi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.monitoringskripsi.entity.User;

import com.monitoringskripsi.model.Mahasiswa;

@Repository
public interface MahasiswaRepository extends JpaRepository<Mahasiswa, Long> {

    List<Mahasiswa> findByNamaContainingIgnoreCase(String nama);

    boolean existsByNim(String nim);

    Mahasiswa findByNim(String nim);

    Mahasiswa findByUserId(Long userId);

    Mahasiswa findByUser(User user);

}