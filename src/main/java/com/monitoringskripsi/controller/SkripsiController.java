package com.monitoringskripsi.controller;

import com.monitoringskripsi.entity.Skripsi;
import com.monitoringskripsi.service.SkripsiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/dosen/skripsi")
public class SkripsiController {

    @Autowired
    private SkripsiService skripsiService;

    @GetMapping
    public String index(Model model) {

        model.addAttribute("skripsiList", skripsiService.findAll());

        return "dosen/skripsi/index";
    }

    @GetMapping("/tambah")
    public String tambah(Model model) {

        model.addAttribute("skripsi", new Skripsi());

        return "dosen/skripsi/form";
    }

    @PostMapping("/simpan")
    public String simpan(@ModelAttribute Skripsi skripsi) {

        skripsiService.save(skripsi);

        return "redirect:/dosen/skripsi";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {

        Skripsi skripsi = skripsiService.findById(id)
                .orElseThrow(() -> new RuntimeException("Data skripsi tidak ditemukan"));

        model.addAttribute("skripsi", skripsi);

        return "dosen/skripsi/form";
    }

    @GetMapping("/hapus/{id}")
    public String hapus(@PathVariable Long id) {

        skripsiService.deleteById(id);

        return "redirect:/dosen/skripsi";
    }

}