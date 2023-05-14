package com.example.aeon.controller;

import com.example.aeon.dto.KaryawanDTO;
import com.example.aeon.entity.Karyawan;
import com.example.aeon.service.KaryawanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
//
import java.util.List;
import java.util.stream.Collectors;


@Controller
@RestController
@RequestMapping("/karyawan")
public class KaryawanController {

    @Autowired
    KaryawanService karyawanService;

    @PostMapping("/")
    public KaryawanDTO create(@RequestBody KaryawanDTO request){
        final Karyawan karyawan = karyawanService.mapToEntity(request);
        final Karyawan result = karyawanService.create(karyawan);
        return karyawanService.mapToDTO(result);
    }

    @PutMapping("/{id}")
    public KaryawanDTO update(@PathVariable Long id, @RequestBody KaryawanDTO request){
        final Karyawan karyawan = karyawanService.mapToEntity(request);
        final Karyawan result = karyawanService.update(id,karyawan);
        return karyawanService.mapToDTO(result);
    }

    @GetMapping("/list")
    public List<KaryawanDTO> findAll(){
        return karyawanService.findAll().stream().map(karyawan -> karyawanService.mapToDTO(karyawan)).collect(Collectors.toList());
    }

//    @GetMapping("/{id}")
//    public Karyawan find(@PathVariable Long id){
//        return  karyawanService.findById(id);
//    }


}
