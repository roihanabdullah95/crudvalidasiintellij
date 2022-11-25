package com.project.tokoonline.contoller;

import com.project.tokoonline.dto.TugasDTO;
import com.project.tokoonline.model.Tugas;
import com.project.tokoonline.response.ResponUserHelper;
import com.project.tokoonline.service.TugasService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Tugas")
public class TugasController {
    @Autowired
    private TugasService tugasService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("")
    public Object getAllTugas(){
        return ResponUserHelper.ok(tugasService.getAllTugas());
    }

    @GetMapping("/{id}")
    public Object getTugas(@PathVariable("id") Long id){
        return ResponUserHelper.ok(tugasService.getTugas(id));
    }

    @PostMapping
    public Object addTugas(@RequestBody TugasDTO tugasDTO){
        return ResponUserHelper.ok(tugasService.addTugas(modelMapper.map(tugasDTO, Tugas.class)));
    }

    @PutMapping("/{id}")
    public Object editUserById(@PathVariable("id") Long id, @RequestBody Tugas tugas){
        return ResponUserHelper.ok(tugasService.editTugas(id, tugas.getNamaBarang(), tugas.getPrice(), tugas.getEmail()));
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable("id") Long id) {
        tugasService.deleteBarangById(id);
    }

}
