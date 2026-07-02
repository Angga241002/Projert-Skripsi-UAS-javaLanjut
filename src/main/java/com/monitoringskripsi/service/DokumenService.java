package com.monitoringskripsi.service;

import java.util.List;
import java.util.Optional;

import com.monitoringskripsi.entity.Dokumen;

public interface DokumenService {

    List<Dokumen> findAll();

    Optional<Dokumen> findById(Long id);

    Dokumen save(Dokumen dokumen);

    void deleteById(Long id);

}