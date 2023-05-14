package com.example.aeon.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name="detail_karyawan")
@Setter
@Getter
public class DetailKaryawan implements Serializable  {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty(message = "harus di isi")
    @Column(name= "nik", length = 50, unique = true )
    private String nik;


    @Column(name="npwp", length = 100)
    private String npwp;

    @OneToOne
//    private Karyawan karyawan;
    @JoinTable(
            name = "karyawan",
            joinColumns = @JoinColumn(name ="id"))
    private Set<DetailKaryawan> detailKaryawan;

}
