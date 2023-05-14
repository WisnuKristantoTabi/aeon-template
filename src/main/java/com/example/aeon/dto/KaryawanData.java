package com.example.aeon.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class KaryawanData {

    @NotEmpty(message = "tidak boleh kosong")
    private String name;

    private String address;

    private String status;

    @NotEmpty()
    private String gender;

    private Date dob;
}
