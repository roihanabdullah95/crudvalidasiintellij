package com.project.tokoonline.contoller;

import com.project.tokoonline.model.BarangImage;
import com.project.tokoonline.service.BarangImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/image")
public class BarangImageController {

    @Autowired
    BarangImageService barangImangeService;

    @PostMapping(consumes = "multipart/form-data")
    public BarangImage addImage(@RequestPart("barangId") String barangId, @RequestPart("file") MultipartFile multipartFile) {
        return barangImangeService.addImage(Long.valueOf(barangId), multipartFile);
    }

    @GetMapping
    public List<BarangImage> getAll() {
        return barangImangeService.findAll();
    }

}
