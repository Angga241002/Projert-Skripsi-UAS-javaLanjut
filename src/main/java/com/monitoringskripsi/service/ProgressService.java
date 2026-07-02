package com.monitoringskripsi.service;

import java.util.List;

import com.monitoringskripsi.entity.Progress;
import com.monitoringskripsi.entity.Skripsi;

public interface ProgressService {

    List<Progress> findAll();

    List<Progress> findBySkripsi(Skripsi skripsi);

    Progress save(Progress progress);

    Progress findById(Long id);

}