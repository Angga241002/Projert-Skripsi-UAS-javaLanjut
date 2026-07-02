package com.monitoringskripsi.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.monitoringskripsi.entity.Progress;
import com.monitoringskripsi.entity.Skripsi;
import com.monitoringskripsi.repository.ProgressRepository;
import com.monitoringskripsi.service.ProgressService;

@Service
public class ProgressServiceImpl implements ProgressService {

    private final ProgressRepository repository;

    public ProgressServiceImpl(ProgressRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Progress> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Progress> findBySkripsi(Skripsi skripsi) {
        return repository.findBySkripsi(skripsi);
    }

    @Override
    public Progress save(Progress progress) {
        return repository.save(progress);
    }

    @Override
    public Progress findById(Long id) {
        return repository.findById(id).orElse(null);
    }

}