package com.project.tokoonline.service;

import com.project.tokoonline.model.PassangerType;
import com.project.tokoonline.model.TiketKereta;

import java.util.List;

public interface TiketKeretaService {
//    Menampung data Array
    List<TiketKereta> getAllTiket();
    TiketKereta addTiket(Long passanger_type_id, TiketKereta tiketKereta);
    TiketKereta getTiket(Long id);

//    Cara menuliskan semua variable menggunakan code dibawah ini
//    TiketKereta editTiket(Long id, String nama, String krl, String departure, String kode_booking, String end_departure, PassangerType passanger_type_id);

//    Menggunakan yg lebih ringkas
    TiketKereta editTiket(Long id, Long passanger_type_id, TiketKereta tiketKereta);


    void deleteTiketById(Long id);
//    method untuk membuat respon body ketika ada yg delete
//    Map<String, Boolean> delete(Long id)
}
