package com.project.tokoonline.service;

import com.project.tokoonline.model.PassangerType;

public interface PassangerTypeService {
    Object getAllPassanger();
    Object addPassanger(PassangerType passangerType);
    Object getPassanger(Long id);
    Object editPassanger(Long id, String name);
    void deletePassangerById(Long id);
}
