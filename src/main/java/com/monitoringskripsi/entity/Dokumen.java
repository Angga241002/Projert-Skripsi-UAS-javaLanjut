package com.monitoringskripsi.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "dokumen")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Dokumen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "progress_id", nullable = false)
    private Progress progress;

    @Column(name = "nama_file")
    private String namaFile;

    @Column(name = "file_path")
    private String filePath;

    @Column(name = "uploaded_at")
    private LocalDateTime uploadedAt;

    @Column(name = "jenis_dokumen")
    private String jenisDokumen;

    @Column(name = "keterangan")
    private String keterangan;

    @PrePersist
    public void prePersist() {
        uploadedAt = LocalDateTime.now();
    }

}