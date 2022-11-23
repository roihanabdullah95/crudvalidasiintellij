package com.project.tokoonline.service;

import com.project.tokoonline.model.Barang;

import java.util.List;

public interface BarangService {
    Object getAllBarang();
    Object addBarang(Barang barang);
    Object getBarang(Long id);
    Object editBarang(Long id, String name, Float price, int count, int rating,  String description, Boolean publish);
    void deleteBarangById(Long id);
}
