package com.example.aeon.service;

import com.example.aeon.dto.KaryawanDTO;
import com.example.aeon.entity.Karyawan;
import com.example.aeon.repository.KaryawanRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class KaryawanImpl implements KaryawanService {

    @Autowired
    KaryawanRepository karyawanRepository;

    @Override
    public Karyawan create(Karyawan karyawan) {
        final Karyawan result = karyawanRepository.save(karyawan);
        return result;
    }

    @Override
    public Karyawan update(Long id, Karyawan karyawan) {
        Karyawan result = findById(id);
        if (result != null){
            result.setNama((karyawan.getNama()));
            result.setJk((karyawan.getJk()));
            result.setAlamat((karyawan.getAlamat()));
//            result.setDob((karyawan.getDob()));
            result.setStatus((karyawan.getStatus()));
            return karyawanRepository.save(result);
        }
        return null;
    }

    @Override
    public List<Karyawan> findAll() {
        return karyawanRepository.findAll();
    }

    @Override
    public Karyawan findById(Long id) {
        Optional<Karyawan> result = karyawanRepository.findById(id);
        if(result.isPresent()){
            return result.get();
        }
        return null;
    }

    ObjectMapper mapper = new ObjectMapper();

    @Override
    public KaryawanDTO mapToDTO(Karyawan karyawan) {
        return mapper.convertValue(karyawan, KaryawanDTO.class);
    }

    @Override
    public Karyawan mapToEntity(KaryawanDTO karyawanDTO) {
        return mapper.convertValue(karyawanDTO, Karyawan.class);
    }
}
