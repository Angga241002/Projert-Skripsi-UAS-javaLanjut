package com.monitoringskripsi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.monitoringskripsi.entity.Progress;
import com.monitoringskripsi.service.ProgressService;

@Controller
@RequestMapping("/mahasiswa/progress")
public class MahasiswaProgressController {

    private final ProgressService progressService;

    public MahasiswaProgressController(ProgressService progressService) {
        this.progressService = progressService;
    }

    @GetMapping
    public String index(Model model) {

        model.addAttribute("progressList",
                progressService.findAll());

        return "mahasiswa/progress/index";
    }

    @GetMapping("/tambah")
    public String tambah(Model model) {

        model.addAttribute("progress",
                new Progress());

        return "mahasiswa/progress/form";
    }

    @PostMapping("/simpan")
    public String simpan(@ModelAttribute Progress progress) {

        progressService.save(progress);

        return "redirect:/mahasiswa/progress";
    }

}