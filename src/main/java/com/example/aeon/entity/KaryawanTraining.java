package com.example.aeon.entity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.persistence.Id;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "karyawantraining")
public class KaryawanTraining {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

//    @Column(name ="tanggal_training")
//    @Temporal(TemporalType.TIMESTAMP)
//    @DateTimeFormat(pattern = "yyMMdd")
//    private Date tanggal_training;

//    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinColumn(name="karyawan_id")
//    private List<Karyawan> karyawan;

}
