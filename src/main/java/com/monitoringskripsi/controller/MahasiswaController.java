package com.monitoringskripsi.controller;

import com.monitoringskripsi.entity.Dokumen;
import com.monitoringskripsi.entity.Progress;
import com.monitoringskripsi.service.DokumenService;
import com.monitoringskripsi.service.MahasiswaService;
import com.monitoringskripsi.service.ProgressService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.*;

@Controller
@RequestMapping("/mahasiswa")
public class MahasiswaController {

    private final MahasiswaService mahasiswaService;
    private final DokumenService dokumenService;
    private final ProgressService progressService;

    public MahasiswaController(
            MahasiswaService mahasiswaService,
            DokumenService dokumenService,
            ProgressService progressService) {

        this.mahasiswaService = mahasiswaService;
        this.dokumenService = dokumenService;
        this.progressService = progressService;
    }

    // ================= DASHBOARD =================

    @GetMapping("/dashboard")
    public String dashboard() {
        return "mahasiswa/dashboard";
    }

    // ================= SKRIPSI =================

    @GetMapping("/skripsi")
    public String skripsi() {
        return "mahasiswa/skripsi";
    }

    // ================= PROGRESS =================

    @GetMapping("/progress")
    public String progress() {
        return "mahasiswa/progress";
    }

    // ================= UPLOAD =================

    @GetMapping("/upload-dokumen")
    public String uploadDokumen() {
        return "mahasiswa/upload-dokumen";
    }

    @PostMapping("/upload-dokumen")
    public String uploadDokumen(

            @RequestParam("file") MultipartFile file,

            @RequestParam("jenisDokumen") String jenisDokumen,

            @RequestParam("keterangan") String keterangan,

            RedirectAttributes redirectAttributes) {

        try {

            if (file.isEmpty()) {

                redirectAttributes.addFlashAttribute(
                        "error",
                        "Silakan pilih file.");

                return "redirect:/mahasiswa/upload-dokumen";
            }

            if (!file.getOriginalFilename().toLowerCase().endsWith(".pdf")) {

                redirectAttributes.addFlashAttribute(
                        "error",
                        "File harus PDF.");

                return "redirect:/mahasiswa/upload-dokumen";
            }

            String uploadDir = "uploads";

            Files.createDirectories(Paths.get(uploadDir));

            String namaFile =
                    System.currentTimeMillis()
                            + "_"
                            + file.getOriginalFilename();

            Path path = Paths.get(uploadDir, namaFile);

            Files.copy(
                    file.getInputStream(),
                    path,
                    StandardCopyOption.REPLACE_EXISTING);

            Progress progress = progressService.findAll().get(0);

            Dokumen dokumen = new Dokumen();

            dokumen.setProgress(progress);
            dokumen.setNamaFile(namaFile);
            dokumen.setFilePath(path.toString());

            // nanti aktif kalau field sudah dibuat
            // dokumen.setJenisDokumen(jenisDokumen);
            // dokumen.setKeterangan(keterangan);

            dokumenService.save(dokumen);

            redirectAttributes.addFlashAttribute(
                    "success",
                    "Dokumen berhasil diupload.");

        } catch (IOException e) {

            redirectAttributes.addFlashAttribute(
                    "error",
                    "Upload gagal.");
        }

        return "redirect:/mahasiswa/upload-dokumen";
    }

    // ================= RIWAYAT =================

    @GetMapping("/riwayat")
    public String riwayat() {
        return "mahasiswa/riwayat";
    }

    // ================= PROFIL =================

    @GetMapping("/profil")
    public String profil() {
        return "mahasiswa/profil";
    }

}