package com.monitoringskripsi.controller;

import com.monitoringskripsi.entity.Progress;
import com.monitoringskripsi.enums.StatusProgress;
import com.monitoringskripsi.service.ProgressService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/dosen/progress")
public class ProgressController {

    private final ProgressService progressService;

    public ProgressController(ProgressService progressService) {
        this.progressService = progressService;
    }

    @GetMapping
    public String index(Model model) {

        model.addAttribute("progressList",
                progressService.findAll());

        return "dosen/progress/index";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Long id,
                         Model model) {

        Progress progress = progressService.findById(id)
                .orElseThrow(() -> new RuntimeException("Progress tidak ditemukan"));

        model.addAttribute("progress", progress);

        model.addAttribute("statusList",
                StatusProgress.values());

        return "dosen/progress/detail";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Progress progress) {

        Progress data = progressService.findById(progress.getId())
                .orElseThrow(() -> new RuntimeException("Progress tidak ditemukan"));

        data.setStatus(progress.getStatus());

        data.setKomentarDosen(progress.getKomentarDosen());

        progressService.save(data);

        return "redirect:/dosen/progress";
    }

}