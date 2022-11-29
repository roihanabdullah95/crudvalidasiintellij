package com.project.tokoonline.service;

import com.project.tokoonline.model.BarangImage;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface BarangImageService {

    List<BarangImage> findAll();
//    untuk mendiskripsikan bahwa di java method findAll menampilkan data array

    BarangImage addImage(Long barangId, MultipartFile multipartFile);
}
