package com.project.tokoonline.service;

import com.project.tokoonline.model.Tugas;

public interface TugasService {
    Object getAllTugas();
    Object addTugas(Tugas tugas);
    Object getTugas(Long id);
    Object editTugas(Long id, String namaBarang, Float price, String email);
    void deleteBarangById(Long id);
}
