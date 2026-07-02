package com.monitoringskripsi.service;

import java.util.List;
import java.util.Optional;

import com.monitoringskripsi.entity.Progress;

public interface ProgressService {

    List<Progress> findAll();

    Optional<Progress> findById(Long id);

    Progress save(Progress progress);

    void deleteById(Long id);

    long count();

}