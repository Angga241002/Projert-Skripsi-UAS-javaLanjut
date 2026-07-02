package com.monitoringskripsi.entity;

import java.time.LocalDate;

import com.monitoringskripsi.enums.StatusSkripsi;
import com.monitoringskripsi.model.Dosen;
import com.monitoringskripsi.model.Mahasiswa;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "skripsi")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Skripsi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String judul;

    @Enumerated(EnumType.STRING)
    @Builder.Default
    private StatusSkripsi status = StatusSkripsi.PROSES;

    @Column(name = "tanggal_mulai")
    private LocalDate tanggalMulai;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mahasiswa_id")
    private Mahasiswa mahasiswa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dosen_id")
    private Dosen dosen;

}