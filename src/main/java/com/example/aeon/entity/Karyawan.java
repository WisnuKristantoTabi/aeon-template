package com.example.aeon.entity;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "karyawan")
public class Karyawan implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id;

    @Column(name = "nama")
    private String nama;

    @Column(name = "jk")
    private String jk;

    @Column(name = "alamat")
    private String alamat;

    @Column(name = "status")
    private String status;

//    @Column(name = "dob")
//    @Temporal(TemporalType.TIMESTAMP)
//    @DateTimeFormat(pattern = "yyMMdd")
//    private Date dob;



}

