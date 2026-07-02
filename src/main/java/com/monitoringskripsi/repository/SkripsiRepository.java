package com.monitoringskripsi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.monitoringskripsi.entity.Skripsi;
import com.monitoringskripsi.enums.StatusSkripsi;
import com.monitoringskripsi.model.Dosen;
import com.monitoringskripsi.model.Mahasiswa;

@Repository
public interface SkripsiRepository extends JpaRepository<Skripsi, Long> {

    List<Skripsi> findByMahasiswa(Mahasiswa mahasiswa);

    List<Skripsi> findByDosen(Dosen dosen);

    boolean existsByMahasiswa(Mahasiswa mahasiswa);

    long countByStatus(StatusSkripsi status);

    List<Skripsi> findByJudulContainingIgnoreCase(String judul);

}