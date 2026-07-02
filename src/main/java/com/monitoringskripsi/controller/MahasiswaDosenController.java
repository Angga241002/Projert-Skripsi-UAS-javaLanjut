package com.monitoringskripsi.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.monitoringskripsi.model.Mahasiswa;
import com.monitoringskripsi.service.MahasiswaService;

@Controller
@RequestMapping("/dosen/mahasiswa")
public class MahasiswaDosenController {

    private final MahasiswaService mahasiswaService;

    public MahasiswaDosenController(MahasiswaService mahasiswaService) {
        this.mahasiswaService = mahasiswaService;
    }

    // ================= TAMPIL DATA =================

    @GetMapping
    public String index(
            @RequestParam(required = false) String keyword,
            Model model) {

        List<Mahasiswa> listMahasiswa = mahasiswaService.cari(keyword);

        model.addAttribute("listMahasiswa", listMahasiswa);
        model.addAttribute("keyword", keyword);

        return "dosen/mahasiswa";
    }

    // ================= FORM TAMBAH =================

    @GetMapping("/tambah")
    public String tambah(Model model) {

        model.addAttribute("mahasiswa", new Mahasiswa());

        return "dosen/tambah-mahasiswa";
    }

    // ================= SIMPAN =================

    @PostMapping("/simpan")
    public String simpan(
            @ModelAttribute Mahasiswa mahasiswa,
            RedirectAttributes redirectAttributes) {

        if (mahasiswaService.existsByNim(mahasiswa.getNim())) {

            redirectAttributes.addFlashAttribute(
                    "error",
                    "NIM sudah digunakan!");

            return "redirect:/dosen/mahasiswa/tambah";
        }

        mahasiswaService.simpan(mahasiswa);

        redirectAttributes.addFlashAttribute(
                "success",
                "Data mahasiswa berhasil ditambahkan.");

        return "redirect:/dosen/mahasiswa";
    }

    // ================= FORM EDIT =================

    @GetMapping("/edit/{id}")
    public String edit(
            @PathVariable Long id,
            Model model) {

        Mahasiswa mahasiswa = mahasiswaService.getById(id);

        if (mahasiswa == null) {
            return "redirect:/dosen/mahasiswa";
        }

        model.addAttribute("mahasiswa", mahasiswa);

        return "dosen/edit-mahasiswa";
    }

    // ================= UPDATE =================

    @PostMapping("/update")
    public String update(
            @ModelAttribute Mahasiswa mahasiswa,
            RedirectAttributes redirectAttributes) {

        Mahasiswa cek = mahasiswaService.findByNim(mahasiswa.getNim());

        if (cek != null && !cek.getId().equals(mahasiswa.getId())) {

            redirectAttributes.addFlashAttribute(
                    "error",
                    "NIM sudah digunakan mahasiswa lain.");

            return "redirect:/dosen/mahasiswa/edit/" + mahasiswa.getId();
        }

        mahasiswaService.update(mahasiswa);

        redirectAttributes.addFlashAttribute(
                "success",
                "Data mahasiswa berhasil diperbarui.");

        return "redirect:/dosen/mahasiswa";
    }

    // ================= HAPUS =================

    @GetMapping("/hapus/{id}")
    public String hapus(
            @PathVariable Long id,
            RedirectAttributes redirectAttributes) {

        mahasiswaService.hapus(id);

        redirectAttributes.addFlashAttribute(
                "success",
                "Data mahasiswa berhasil dihapus.");

        return "redirect:/dosen/mahasiswa";
    }

}