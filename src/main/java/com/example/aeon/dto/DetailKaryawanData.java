package com.example.aeon.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DetailKaryawanData {
    @NotEmpty(message = "harus di isi")
    private String nik;

    private String npwp;
}
