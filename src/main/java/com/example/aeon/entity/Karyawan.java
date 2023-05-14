package com.example.aeon.entity;



import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table (name="karyawan")
@Setter
@Getter
public class Karyawan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty(message = "harus di isi")
    @Column(name="nama", length = 100)
    private String name;

    @Column(name="alamat", length = 100)
    private String address;

    @Column(name="status", length = 50)
    private String status;

    @NotEmpty()
    @Column(name="jk", length = 10)
    private String gender;

    @Column(name="dob")
    @Temporal(TemporalType.TIME)
    @DateTimeFormat(pattern = "yyMMdd")
    private Date dob;




}


