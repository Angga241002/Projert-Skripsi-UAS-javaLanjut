package com.monitoringskripsi.controller;

import com.monitoringskripsi.entity.Skripsi;
import com.monitoringskripsi.repository.DosenRepository;
import com.monitoringskripsi.repository.MahasiswaRepository;
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
    @Autowired
    private MahasiswaRepository mahasiswaRepository;

    @Autowired
    private DosenRepository dosenRepository;

    @GetMapping
    public String index(

            @RequestParam(required = false) String keyword,
            Model model) {

        if (keyword != null && !keyword.isEmpty()) {

            model.addAttribute("skripsiList",
                    skripsiService.search(keyword));

        } else {

            model.addAttribute("skripsiList",
                    skripsiService.findAll());

        }

        model.addAttribute("keyword", keyword);

        return "dosen/skripsi/index";

    }

    @GetMapping("/tambah")
    public String tambah(Model model) {

        model.addAttribute("skripsi", new Skripsi());

        model.addAttribute("mahasiswaList", mahasiswaRepository.findAll());

        model.addAttribute("dosenList", dosenRepository.findAll());

        return "dosen/skripsi/form";
    }

    @PostMapping("/simpan")
    public String simpan(

            @ModelAttribute Skripsi skripsi,

            @RequestParam Long mahasiswaId,

            @RequestParam Long dosenId

    ) {

        skripsi.setMahasiswa(

                mahasiswaRepository.findById(mahasiswaId).orElse(null)

        );

        skripsi.setDosen(

                dosenRepository.findById(dosenId).orElse(null)

        );

        skripsiService.save(skripsi);

        return "redirect:/dosen/skripsi";

    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {

        Skripsi skripsi = skripsiService.findById(id)
                .orElseThrow(() -> new RuntimeException("Data tidak ditemukan"));

        model.addAttribute("skripsi", skripsi);

        model.addAttribute("mahasiswaList", mahasiswaRepository.findAll());

        model.addAttribute("dosenList", dosenRepository.findAll());

        return "dosen/skripsi/form";
    }
    @GetMapping("/hapus/{id}")
    public String hapus(@PathVariable Long id) {

        skripsiService.deleteById(id);

        return "redirect:/dosen/skripsi";
    }

}