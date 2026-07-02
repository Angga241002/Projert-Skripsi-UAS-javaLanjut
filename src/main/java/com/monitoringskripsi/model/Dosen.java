package com.monitoringskripsi.model;

import java.util.List;

import com.monitoringskripsi.entity.Skripsi;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "dosen")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Dosen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nidn;

    @Column(nullable = false)
    private String nama;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(length = 20)
    private String noHp;

    private String fakultas;

    private String programStudi;

    @OneToMany(mappedBy = "dosen")
    private List<Skripsi> daftarSkripsi;

}