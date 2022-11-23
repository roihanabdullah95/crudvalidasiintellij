package com.project.tokoonline.contoller;

import com.project.tokoonline.model.Tugas;
import com.project.tokoonline.service.TugasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Tugas")
public class TugasController {
    @Autowired
    private TugasService tugasService;

    @GetMapping("")
    public Object getAllTugas(){
        return tugasService.getAllTugas();
    }

    @GetMapping("/{id}")
    public Object getTugas(@PathVariable("id") Long id){
        return tugasService.getTugas(id);
    }

    @PostMapping
    public Object addTugas(@RequestBody Tugas tugas){
        return tugasService.addTugas(tugas);
    }

    @PutMapping("/{id}")
    public Object editUserById(@PathVariable("id") Long id, @RequestBody Tugas tugas){
        return tugasService.editTugas(id, tugas.getNamaBarang(), tugas.getPrice(), tugas.getEmail());
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable("id") Long id) {
        tugasService.deleteBarangById(id);
    }

}
