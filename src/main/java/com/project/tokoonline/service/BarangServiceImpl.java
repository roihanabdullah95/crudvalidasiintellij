package com.project.tokoonline.service;


import com.project.tokoonline.exception.InternalErrorException;
import com.project.tokoonline.exception.NotFoundException;
import com.project.tokoonline.model.Barang;
import com.project.tokoonline.model.User;
import com.project.tokoonline.repository.BarangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BarangServiceImpl implements BarangService {
   @Autowired
    BarangRepository barangRepository;

    @Override
    public Object getAllBarang() {
        try {
            return barangRepository.findAll();
        } catch (Exception e) {
            return "Data Ada yg bernilai Null";
        }
    }

    @Override
    public Object addBarang(Barang barang) {
        return barangRepository.save(barang);
    }

    @Override
    public Object getBarang(Long id) {
//        var ini dipakai ketika sudah mengimplementasi kan global exception handler
        var barang = barangRepository.findById(id).orElseThrow(() -> new NotFoundException("Id tidak ditemukan"));
        try {
//            Var di bawah ini sebelum menggunakan package exception not found
//            var barang = barangRepository.findById(id).get();
            return barangRepository.save(barang);
        } catch (Exception e) {
            //            digunakan saat sudah memakai exception
            throw new InternalErrorException("Data ada yang bernilai null");
//            return dibawah ini sebelum menggunakan throw new
//            return "Data ada yg bernilai Null";
        }
    }

    @Override
    public Object editBarang(Long id, String name, Float price, int count, int rating, String description, Boolean publish) {
        Barang barang = barangRepository.findById(id).get();
        barang.setName(name);
        barang.setPrice(price);
        barang.setCount(count);
        barang.setRating(rating);
        barang.setDescription(description);
        barang.setPublish(publish);
        return barangRepository.save(barang);
    }

    @Override
    public void deleteBarangById(Long id) {
        barangRepository.deleteById(id);
    }
}
