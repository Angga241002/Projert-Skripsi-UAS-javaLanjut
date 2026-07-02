package com.monitoringskripsi.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.monitoringskripsi.entity.Skripsi;
import com.monitoringskripsi.repository.SkripsiRepository;
import com.monitoringskripsi.service.SkripsiService;

@Service
public class SkripsiServiceimpl implements SkripsiService {

    private final SkripsiRepository skripsiRepository;

    public SkripsiServiceimpl(SkripsiRepository skripsiRepository) {
        this.skripsiRepository = skripsiRepository;
    }

    @Override
    public List<Skripsi> findAll() {
        return skripsiRepository.findAll();
    }

    @Override
    public Optional<Skripsi> findById(Long id) {
        return skripsiRepository.findById(id);
    }

    @Override
    public Skripsi save(Skripsi skripsi) {
        return skripsiRepository.save(skripsi);
    }

    @Override
    public void deleteById(Long id) {
        skripsiRepository.deleteById(id);
    }

    @Override
    public long count() {
        return skripsiRepository.count();
    }
}