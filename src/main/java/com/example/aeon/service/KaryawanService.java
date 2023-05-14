package com.example.aeon.service;

import com.example.aeon.entity.Karyawan;
import com.example.aeon.repository.KaryawanRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class KaryawanService {

    @Autowired
    private KaryawanRepository karyawanRepository;

    public Karyawan save(Karyawan karyawan){
        return karyawanRepository.save(karyawan);
    }

//    public Karyawan update(Long id, Karyawan karyawan){
//        Karyawan result = karyawanRepository.findById(id).get();
//        if (result != null){
//            result.setName(karyawan.getName());
//            result.setGender(karyawan.getGender());
//            result.setStatus(karyawan.getStatus());
//            result.setDob(karyawan.getDob());
//            return karyawanRepository.save(result);
//        }
//        return null;
//    }

    public Karyawan findById(Long id){
//        Optional<Karyawan> karyawan =karyawanRepository.findByNameContains()
        return karyawanRepository.findById(id).get();
//        return null;
    }

    public Iterable<Karyawan> findAll(){
        return karyawanRepository.findAll();
    }





}
