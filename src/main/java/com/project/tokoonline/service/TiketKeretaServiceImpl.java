package com.project.tokoonline.service;

import com.project.tokoonline.exception.NotFoundException;
import com.project.tokoonline.model.PassangerType;
import com.project.tokoonline.model.TiketKereta;
import com.project.tokoonline.repository.PassangerTypeRepository;
import com.project.tokoonline.repository.TiketKeretaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class TiketKeretaServiceImpl implements  TiketKeretaService {
//    Membuat end date dimana start date + 3 jam
//    private :
//    static : bisa langsung di akses dimethod ini
//    final : nilai tidak dapat dirubah
    private static final int HOUR = 3600 * 1000;

//    membuat kode booking yaitu angka acak sebanyak 12 karakter
//    Random itu library untuk membuat program acak.
    private String random(){
        Random random = new Random();
        String result = "";
        String character = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890_-!@$%&";
        for (int i = 0; i < 12; i++) {
            result += character.charAt(random.nextInt(character.length()));
        }
        return result;
    }
    @Autowired
    private TiketKeretaRepository tiketKeretaRepository;

    @Autowired
    private PassangerTypeRepository passangerTypeRepository;

    @Transactional(readOnly = true)
    @Override
    public List<TiketKereta> getAllTiket() {
            return tiketKeretaRepository.findAll();
    }

    @Transactional
    @Override
    public TiketKereta addTiket(Long passanger_type_id, TiketKereta tiketKereta) {
        PassangerType typePassanger = passangerTypeRepository.findById(passanger_type_id).orElseThrow(() -> new NotFoundException("Passanger Type id not Found"));
        tiketKereta.setPassanger_type_id(typePassanger);
//        menampilkan hasil dari start date + 3 jam
        tiketKereta.setEnd_date(new Date(new Date().getTime() + 3 * HOUR));
//        Menampilkan hasil program acak random
        tiketKereta.setKode_booking(random());
        return tiketKeretaRepository.save(tiketKereta);
    }

    @Override
    public TiketKereta getTiket(Long id) {
           var tiketKereta = tiketKeretaRepository.findById(id).get();
           return tiketKeretaRepository.save(tiketKereta);
    }

//    Cara agar tidak terlalu panjang menuliskan variable pada method edit
    @Override
    public TiketKereta  editTiket(Long id, Long passanger_type_id, TiketKereta tiketKereta) {
        TiketKereta update = tiketKeretaRepository.findById(id).orElseThrow(() -> new NotFoundException("Tiket Kereta id Not Found"));
        PassangerType passangerType = passangerTypeRepository.findById(passanger_type_id).orElseThrow(() -> new NotFoundException("Passanger Type Id not found"));
        update.setNama(tiketKereta.getNama());
        update.setKrl(tiketKereta.getKrl());
        update.setDeparture(tiketKereta.getDeparture());
        update.setEnd_departure(tiketKereta.getEnd_departure());
        return tiketKeretaRepository.save(update);
    }

//    @Override
//    public TiketKereta editTiket(Long id, String nama, String krl, String departure,  String kode_booking, String end_departure, PassangerType passanger_type_id) {
//       TiketKereta tiketKereta = tiketKeretaRepository.findById(id).get();
//       tiketKereta.setNama(nama);
//       tiketKereta.setKrl(krl);
//       tiketKereta.setDeparture(departure);
//       tiketKereta.setKode_booking(kode_booking);
//       tiketKereta.setEnd_departure(end_departure);
//       tiketKereta.setPassanger_type_id(passanger_type_id);
//       return tiketKeretaRepository.save(tiketKereta);
//    }

    @Transactional
    @Override
    public void deleteTiketById(Long id) {
    tiketKeretaRepository.deleteById(id);
    }
}
