package com.example.aeon.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name="rekening")
@Setter
@Getter
public class Rekening implements Serializable  {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty(message = "harus di isi")
    @Column(name= "jenis", length = 100)
    private String type;

    @Column(name= "nama", length = 100)
    private String name;

    @Column(name= "nomor", length = 100)
    private String number;

    @ManyToOne
    private Karyawan karyawan;

}
