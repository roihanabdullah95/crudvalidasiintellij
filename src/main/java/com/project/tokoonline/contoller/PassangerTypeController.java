package com.project.tokoonline.contoller;

import com.project.tokoonline.model.PassangerType;
import com.project.tokoonline.service.PassangerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Passanger")
public class PassangerTypeController {
    @Autowired
    private PassangerTypeService passangerTypeService;

    @GetMapping("")
    public Object getAllPassanger(){
        return passangerTypeService.getAllPassanger();
    }

    @GetMapping("/{id}")
    public Object getPassanger(@PathVariable("id") Long id){
        return passangerTypeService.getPassanger(id);
    }

    @PostMapping
    public Object addPassanger(@RequestBody PassangerType passangerType){
        return passangerTypeService.addPassanger(passangerType);
    }

    @PutMapping("/{id}")
    public Object editPassangerById(@PathVariable("id") Long id, @RequestBody PassangerType passangerType){
        return  passangerTypeService.editPassanger(id, passangerType.getName());
    }

    @DeleteMapping("/{id}")
    public void deletePassangerById(@PathVariable("id") Long id){
        passangerTypeService.deletePassangerById(id);
    }
}
