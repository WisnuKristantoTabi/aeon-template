package com.example.aeon.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="karyawan_training")
@Setter
@Getter
public class KaryawanTraining implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty(message = "harus di isi")
    @Column(name="tanggal_training")
    @Temporal(TemporalType.TIME)
    @DateTimeFormat(pattern = "yyMMdd")
    private Date dateTraining;

    @ManyToOne
    private Karyawan karyawan;

    @ManyToOne
    private Training training;
}
