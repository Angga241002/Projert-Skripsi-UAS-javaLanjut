package com.monitoringskripsi.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.monitoringskripsi.entity.Dokumen;
import com.monitoringskripsi.repository.DokumenRepository;
import com.monitoringskripsi.service.DokumenService;

@Service
public class DokumenServiceImpl implements DokumenService {

    private final DokumenRepository dokumenRepository;

    public DokumenServiceImpl(DokumenRepository dokumenRepository) {
        this.dokumenRepository = dokumenRepository;
    }

    @Override
    public List<Dokumen> findAll() {
        return dokumenRepository.findAll();
    }

    @Override
    public Optional<Dokumen> findById(Long id) {
        return dokumenRepository.findById(id);
    }

    @Override
    public Dokumen save(Dokumen dokumen) {
        return dokumenRepository.save(dokumen);
    }

    @Override
    public void deleteById(Long id) {
        dokumenRepository.deleteById(id);
    }

}