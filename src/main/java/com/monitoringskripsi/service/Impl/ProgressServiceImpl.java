package com.monitoringskripsi.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.monitoringskripsi.entity.Progress;
import com.monitoringskripsi.repository.ProgressRepository;
import com.monitoringskripsi.service.ProgressService;

@Service
public class ProgressServiceImpl implements ProgressService {

    private final ProgressRepository progressRepository;

    public ProgressServiceImpl(ProgressRepository progressRepository) {
        this.progressRepository = progressRepository;
    }

    @Override
    public List<Progress> findAll() {
        return progressRepository.findAll();
    }

    @Override
    public Optional<Progress> findById(Long id) {
        return progressRepository.findById(id);
    }

    @Override
    public Progress save(Progress progress) {
        return progressRepository.save(progress);
    }

    @Override
    public void deleteById(Long id) {
        progressRepository.deleteById(id);
    }

    @Override
    public List<Progress> search(String keyword) {

        if (keyword == null || keyword.isBlank()) {
            return progressRepository.findAll();
        }

        return progressRepository.findByBabContainingIgnoreCase(keyword);
    }

}