package com.project.tokoonline.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponHelper {
    public static <T> CommonResponse<T> ok(T data){
        CommonResponse<T> response= new CommonResponse<>();
        response.setMessage("Sukses Mas Bro");
        response.setStatus("200");
        response.setData(data);
        return response;
    }

    public static <T> ResponseEntity<CommonResponse<T>> error (String error, HttpStatus httpStatus){
        CommonResponse<T> response = new CommonResponse<>();
//        Merubah String to Number menggunakan String.valueOf()
        response.setStatus(String.valueOf(httpStatus.value()));
        response.setMessage(httpStatus.name());
        response.setData((T)error);
        return new ResponseEntity<>(response, httpStatus);
    }
}
