package com.example.aeon.service;

import com.example.aeon.entity.DetailKaryawan;
import com.example.aeon.repository.DetailKaryawanRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class DetailKaryawanService {


    @Autowired
    private DetailKaryawanRepository detailKaryawanRepository;

    public DetailKaryawan save(DetailKaryawan detailKaryawan){
        return detailKaryawanRepository.save(detailKaryawan);
    }

    public DetailKaryawan findById(Long id){
//        Optional<Karyawan> karyawan =karyawanRepository.findByNameContains()
        return detailKaryawanRepository.findById(id).get();
//        return null;
    }

    public Iterable<DetailKaryawan> findAll(){
        return detailKaryawanRepository.findAll();
    }

    public void DetailKaryawan (DetailKaryawan detailKaryawan, Long detailkaryawanId){
        DetailKaryawan detailKaryawans = findById(detailkaryawanId);
        if(detailKaryawans == null){
            throw  new RuntimeException("Tidak Ditemukan");
        }
        detailKaryawans.getDetailKaryawan().add(detailKaryawan);
        save(detailKaryawans);
    }
}
