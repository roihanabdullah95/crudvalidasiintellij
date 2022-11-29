package com.project.tokoonline.contoller;


import com.project.tokoonline.model.Barang;
import com.project.tokoonline.response.ResponHelper;
import com.project.tokoonline.service.BarangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Barang")
public class BarangController {
    @Autowired
    private BarangService barangService;

    @GetMapping("/")
    public Object getAllBarang() {
        return ResponHelper.ok(barangService.getAllBarang());
    }

    @GetMapping("/{id}")
    public Object getBarang(@PathVariable("id") Long id) {
        return ResponHelper.ok(barangService.getBarang(id));
    }

    @PostMapping
    public Object addBarang(@RequestBody Barang barang) {
        return ResponHelper.ok(barangService.addBarang(barang));
    }

    @PutMapping("/{id}")
    public Object editBarangById(@PathVariable("id") Long id, @RequestBody Barang barang) {
        return ResponHelper.ok(barangService.editBarang(id, barang.getName(), barang.getPrice(), barang.getCount(), barang.getRating(), barang.getDescription(), barang.getPublish()));
    }

    @DeleteMapping("/{id}")
    public void deleteBarangById(@PathVariable("id") Long id) {
        barangService.deleteBarangById(id);
    }
}
