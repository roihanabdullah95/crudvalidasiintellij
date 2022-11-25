package com.project.tokoonline.service;

import com.project.tokoonline.exception.InternalErrorException;
import com.project.tokoonline.exception.NotFoundException;
import com.project.tokoonline.model.Tugas;
import com.project.tokoonline.repository.TugasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TugasServiceImpl implements TugasService {
    @Autowired
    TugasRepository tugasRepository;

    @Override
    public Object getAllTugas() {
        try {
            return tugasRepository.findAll();
        } catch (Exception e) {
            return "Data Ada yg bernilai Null";
        }
    }

    @Override
    public Object addTugas(Tugas tugas) {
        String email = tugas.getEmail();
        var validasi = tugasRepository.findByEmail(email);
        if (validasi.isPresent()){
            throw new InternalErrorException("Pemilik Sudah Terdaftar, Silahkan menggunakan Email Lain");
        }else{
            return tugasRepository.save(tugas);
        }

    }

    @Override
    public Object getTugas(Long id) {
        var tugas = tugasRepository.findById(id).orElseThrow(() -> new NotFoundException("Id tidak ditemukan"));
        try {

            return tugasRepository.save(tugas);
        } catch (Exception e) {
           throw new InternalErrorException("Data ada yang bernilai null");
        }
    }

    @Override
    public Object editTugas(Long id, String namaBarang, Float price, String email) {
        Tugas tugas = tugasRepository.findById(id).get();
        tugas.getEmail();
        var validasi = tugasRepository.findByEmail(email);
        tugas.setNamaBarang(namaBarang);
        tugas.setPrice(price);
        tugas.setEmail(email);

        if (validasi.isPresent()){
            throw new InternalErrorException("Pemilik Sudah Terdaftar, Silahkan menggunakan Email Lain");
        }else{
            return tugasRepository.save(tugas);
        }

    }

    @Override
    public void deleteBarangById(Long id) {
        tugasRepository.deleteById(id);
    }
}
