package com.example.aeon.repository;


import com.example.aeon.entity.Karyawan;
import org.springframework.data.repository.CrudRepository;

public interface KaryawanRepository extends CrudRepository<Karyawan,Long> {
//    Page<Karyawan> findByNameContains(String name, Pageable pageable);
}
