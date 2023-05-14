package com.example.aeon.service;

import com.example.aeon.dto.KaryawanDTO;
import com.example.aeon.entity.Karyawan;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public interface KaryawanService {
    Karyawan create(Karyawan karyawan);
    Karyawan update(Long id, Karyawan karyawan);
    List<Karyawan> findAll();


    Karyawan findById(Long id);

    KaryawanDTO mapToDTO(Karyawan karyawan);
    Karyawan mapToEntity(KaryawanDTO karyawanDTO);

}
