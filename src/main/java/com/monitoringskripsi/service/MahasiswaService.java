package com.monitoringskripsi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.monitoringskripsi.model.Mahasiswa;
import com.monitoringskripsi.repository.MahasiswaRepository;
import com.monitoringskripsi.repository.UserRepository;

@Service
public class MahasiswaService {

    private final MahasiswaRepository mahasiswaRepository;
    private final MahasiswaRepository mahasiswaRepository;
    private final UserRepository userRepository;

    public MahasiswaService(

        MahasiswaRepository mahasiswaRepository,

        UserRepository userRepository){

    this.mahasiswaRepository = mahasiswaRepository;
    this.userRepository = userRepository;

}

    // Menampilkan semua mahasiswa
    public List<Mahasiswa> getAllMahasiswa() {
        return mahasiswaRepository.findAll();
    }

    // Simpan mahasiswa
    public Mahasiswa simpan(Mahasiswa mahasiswa) {
        return mahasiswaRepository.save(mahasiswa);
    }

    // Cari berdasarkan id
    public Mahasiswa findByUserId(Long userId) {

    return mahasiswaRepository.findByUserId(userId);

}

    // Update mahasiswa
    public Mahasiswa update(Mahasiswa mahasiswa) {
        return mahasiswaRepository.save(mahasiswa);
    }

    // Hapus mahasiswa
    public void hapus(Long id) {
        mahasiswaRepository.deleteById(id);
    }

    // Cari berdasarkan nama
    public List<Mahasiswa> cari(String keyword) {

        if (keyword == null || keyword.isBlank()) {
            return mahasiswaRepository.findAll();
        }

        return mahasiswaRepository.findByNamaContainingIgnoreCase(keyword);
    }

    public boolean existsByNim(String nim) {
    return mahasiswaRepository.existsByNim(nim);
}

public Mahasiswa findByNim(String nim) {
    return mahasiswaRepository.findByNim(nim);
}

public Mahasiswa getMahasiswaLogin() {

    String username = SecurityUtil.getUsername();

    User user = userRepository
            .findByUsername(username)
            .orElse(null);

    if(user == null){
        return null;
    }

    return mahasiswaRepository.findByUser(user);

}

}