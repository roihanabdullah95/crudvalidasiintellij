package com.project.tokoonline.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponUserHelper {
    public static <T> ResponseEntity<CommonUserResponse <T>> ok(T data){
        CommonUserResponse<T> response= new CommonUserResponse<>();
        response.setMessage("Sukses Mas Bro");
        response.setStatus("200");
        response.setData(data);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public static <T> ResponseEntity<CommonUserResponse<T>> error (String error, HttpStatus httpStatus){
        CommonUserResponse<T> response = new CommonUserResponse<>();
//        Merubah String to Number menggunakan String.valueOf()
        response.setStatus(String.valueOf(httpStatus.value()));
        response.setMessage(httpStatus.name());
        response.setData((T)error);
        return new ResponseEntity<>(response, httpStatus);
    }
}
