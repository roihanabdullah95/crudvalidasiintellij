package com.project.tokoonline.service;

import com.project.tokoonline.exception.NotFoundException;
import com.project.tokoonline.model.BarangImage;
import com.project.tokoonline.repository.BarangImageRepository;
import com.project.tokoonline.repository.BarangRepository;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class BarangImageSeriviceImpl implements  BarangImageService{

    @Autowired
    BarangRepository barangRepository;

    @Autowired
    BarangImageRepository barangImageRepository;

    @Override
    public List<BarangImage> findAll() {
        return barangImageRepository.findAll();
    }

    @Override
    public BarangImage addImage(Long barangId, MultipartFile multipartFile) {
        BarangImage addImage = new BarangImage();
        addImage.setBarangId(barangRepository.findById(barangId).get());
        addImage.setImageUrl(confertToBase64(multipartFile));
        return barangImageRepository.save(addImage);
    }

    private String confertToBase64(MultipartFile file) {
        try {
            byte[] image = Base64.encodeBase64(file.getBytes());
            String result = new String(image);
            return "data:" + file.getContentType() + ";base64," + result;
        } catch (Exception e) {
            throw new NotFoundException(e.getMessage());
        }
    }
}
