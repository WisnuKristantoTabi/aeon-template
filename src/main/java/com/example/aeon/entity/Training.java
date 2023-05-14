package com.example.aeon.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name="training")
@Setter
@Getter
public class Training implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty(message = "harus di isi")
    @Column(name= "nama_pengajar", length = 100)
    private String coach;

    @NotEmpty(message = "harus di isi")
    @Column(name="tema", length = 100)
    private String theme;
}
