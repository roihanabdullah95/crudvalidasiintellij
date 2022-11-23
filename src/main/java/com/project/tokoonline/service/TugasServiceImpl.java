package com.project.tokoonline.service;

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
        return tugasRepository.save(tugas);
    }

    @Override
    public Object getTugas(Long id) {
        try {
            var tugas = tugasRepository.findById(id).get();
            return tugasRepository.save(tugas);
        } catch (Exception e) {
            return "Data ada yg bernilai Null";
        }
    }

    @Override
    public Object editTugas(Long id, String namaBarang, Float price, String email) {
        Tugas tugas = tugasRepository.findById(id).get();
        tugas.setNamaBarang(namaBarang);
        tugas.setPrice(price);
        tugas.setEmail(email);
        return tugasRepository.save(tugas);
    }

    @Override
    public void deleteBarangById(Long id) {
        tugasRepository.deleteById(id);
    }
}
