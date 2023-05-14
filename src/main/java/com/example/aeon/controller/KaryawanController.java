package com.example.aeon.controller;

import com.example.aeon.dto.KaryawanData;
import com.example.aeon.dto.ResponseData;
import com.example.aeon.entity.DetailKaryawan;
import com.example.aeon.entity.Karyawan;
import com.example.aeon.service.KaryawanService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.Errors;

@RestController
@RequestMapping("/v1/karyawan")
public class KaryawanController {

  @Autowired
  private KaryawanService karyawanService;

  @Autowired
  private ModelMapper modelMapper;

  @PostMapping
  public ResponseEntity<ResponseData<Karyawan>> save(@Valid @RequestBody KaryawanData karyawanData, Errors errors){

    ResponseData<Karyawan> responseKaryawanData = new ResponseData<>();
    ResponseData<DetailKaryawan> responseDetailData = new ResponseData<>();
    if(errors.hasErrors()){
      for (ObjectError error: errors.getAllErrors()){
        responseKaryawanData.getMessages().add(error.getDefaultMessage());
        responseDetailData.getMessages().add(error.getDefaultMessage());
      }
      responseKaryawanData.setStatus(false);
      responseKaryawanData.setPayload(null);
      responseDetailData.setStatus(false);
      responseDetailData.setPayload(null);
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseKaryawanData);
    }

    Karyawan karyawan = modelMapper.map(karyawanData, Karyawan.class);
//    DetailKaryawan detailKaryawan = modelMapper.map(karyawanData, Karyawan.class);

//    responseData.setStatus(true);
//    responseData.setPayload(karyawanService.save(karyawan));
//    esponseData.setStatus(true);
//    responseData.setPayload(karyawanService.save(karyawan));
//    return ResponseEntity.ok(responseData);
    return null;
  }

  @GetMapping
  public Iterable<Karyawan> findAll(){
    return karyawanService.findAll();
  }

  @GetMapping("/{id}")
  public Karyawan findById(@PathVariable("id") Long id){
    return karyawanService.findById(id);
  }

  @PutMapping
  public ResponseEntity<ResponseData<Karyawan>> update(@Valid @RequestBody KaryawanData karyawanData, Errors errors){

    ResponseData<Karyawan> responseData = new ResponseData<>();
    if(errors.hasErrors()){
      for (ObjectError error: errors.getAllErrors()){
        responseData.getMessages().add(error.getDefaultMessage());
      }
      responseData.setStatus(false);
      responseData.setPayload(null);
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
    }

    Karyawan karyawan = modelMapper.map(karyawanData, Karyawan.class);

    responseData.setStatus(true);
    responseData.setPayload(karyawanService.save(karyawan));
    return ResponseEntity.ok(responseData);
  }
}
