package com.monitoringskripsi.service;

import java.util.List;
import java.util.Optional;

import com.monitoringskripsi.entity.Skripsi;

public interface SkripsiService {

    List<Skripsi> findAll();

    Optional<Skripsi> findById(Long id);

    Skripsi save(Skripsi skripsi);

    void deleteById(Long id);

    long count();

    List<Skripsi> search(String keyword);

}