package com.example.aeon.controller;


import com.example.aeon.dto.DetailKaryawanData;
import com.example.aeon.dto.ResponseData;
import com.example.aeon.entity.DetailKaryawan;
import com.example.aeon.service.DetailKaryawanService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.Errors;

@RestController
@RequestMapping("/v1/detail")
public class DetailKaryawanController {

    @Autowired
    private DetailKaryawanService detailKaryawanService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<ResponseData<DetailKaryawan>> save(@Valid @RequestBody DetailKaryawanData detailKaryawanData, Errors errors){

        ResponseData<DetailKaryawan> responseData = new ResponseData<>();
        if(errors.hasErrors()){
            for (ObjectError error: errors.getAllErrors()){
                responseData.getMessages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }

        DetailKaryawan detailKaryawan = modelMapper.map(detailKaryawanData, DetailKaryawan.class);

        responseData.setStatus(true);
        responseData.setPayload(detailKaryawanService.save(detailKaryawan));
        return ResponseEntity.ok(responseData);
    }

    @GetMapping
    public Iterable<DetailKaryawan> findAll(){
        return detailKaryawanService.findAll();
    }

}
