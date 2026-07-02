package com.monitoringskripsi.entity;

import java.time.LocalDate;

import com.monitoringskripsi.enums.StatusProgress;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "progress")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Progress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relasi ke skripsi
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "skripsi_id", nullable = false)
    private Skripsi skripsi;

    // BAB yang dikerjakan
    @Column(nullable = false)
    private String bab;

    // Judul progress
    @Column(name = "judul_progress", nullable = false)
    private String judulProgress;

    // Persentase penyelesaian
    @Column(nullable = false)
    private Integer persentase;

    // Catatan dari mahasiswa
    @Column(columnDefinition = "TEXT")
    private String catatan;

    // Tanggal upload progress
    private LocalDate tanggal;

    // Status progress
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @Builder.Default
    private StatusProgress status = StatusProgress.PROSES;

    // Lokasi file BAB yang diupload
    @Column(name = "file_path")
    private String filePath;

    // Komentar dari dosen
    @Column(name = "komentar_dosen", columnDefinition = "TEXT")
    private String komentarDosen;

}