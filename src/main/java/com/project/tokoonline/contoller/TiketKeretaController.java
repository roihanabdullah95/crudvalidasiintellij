package com.project.tokoonline.contoller;

import com.project.tokoonline.dto.TiketKeretaDTO;
import com.project.tokoonline.model.TiketKereta;
import com.project.tokoonline.response.CommonResponse;
import com.project.tokoonline.response.ResponHelper;
import com.project.tokoonline.service.TiketKeretaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/TiketKereta")
public class TiketKeretaController {
    @Autowired
    private TiketKeretaService tiketKeretaService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("")
    public Object getAllTiket(){
        return tiketKeretaService.getAllTiket();
    }

    @GetMapping("/{id}")
    public Object getTiket(@PathVariable("id") Long id){
        return tiketKeretaService.getTiket(id);
    }

    @PostMapping ("/{passanger_type_id}")
    public CommonResponse<TiketKereta> addTiket(@PathVariable("passanger_type_id") Long passanger_type_id, @RequestBody TiketKeretaDTO tiketKeretaDTO){
        return ResponHelper.ok(tiketKeretaService.addTiket(passanger_type_id, modelMapper.map(tiketKeretaDTO, TiketKereta.class)));
    }
// Masih berhubungan ketika di service menggunakan variable semua dituliskan pakai code dibawah ini tapi kalo di irngkas maka menggunakan code dibawahnya
//    @PutMapping("/{id}")
//    public Object editTiketById(@PathVariable("id") Long id, @RequestBody TiketKereta tiketKereta) {
//        return tiketKeretaService.editTiket(id, tiketKereta.getNama(), tiketKereta.getKrl(), tiketKereta.getDeparture(),  tiketKereta.getKode_booking(), tiketKereta.getEnd_departure(),  tiketKereta.getPassanger_type_id());
//    }

    @PutMapping("/{id}")
    public Object editTiketById(@PathVariable("id") Long id, @RequestParam("passanger_type_id") Long passanger_type_id, @RequestBody TiketKeretaDTO tiketKeretaDTO) {
        return tiketKeretaService.editTiket(id, passanger_type_id, modelMapper.map(tiketKeretaDTO, TiketKereta.class));
    }

    @DeleteMapping("/{id}")
    public void deleteTiketById(@PathVariable("id") Long id){
        tiketKeretaService.deleteTiketById(id);
    }
}
