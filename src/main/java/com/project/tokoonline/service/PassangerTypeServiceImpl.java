package com.project.tokoonline.service;

import com.project.tokoonline.model.PassangerType;
import com.project.tokoonline.repository.PassangerTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PassangerTypeServiceImpl implements  PassangerTypeService{
    @Autowired
    PassangerTypeRepository passangerTypeRepository;


    @Override
    public Object getAllPassanger() {
        try{
            return passangerTypeRepository.findAll();
        } catch (Exception e) {
            return "Data ada yg bernilai Null";
        }
    }

    @Override
    public Object addPassanger(PassangerType passangerType) {
        return passangerTypeRepository.save(passangerType);
    }

    @Override
    public Object getPassanger(Long id) {
        try{
            var passangerType = passangerTypeRepository.findById(id).get();
            return passangerTypeRepository.save(passangerType);
        }catch (Exception e){
            return " Data ada yg bernilai Null";
        }
    }

    @Override
    public Object editPassanger(Long id, String name) {
        PassangerType passangerType = passangerTypeRepository.findById(id).get();
        passangerType.setName(name);
        return passangerTypeRepository.save(passangerType);
    }

    @Override
    public void deletePassangerById(Long id) {
        passangerTypeRepository.deleteById(id);
    }
}
