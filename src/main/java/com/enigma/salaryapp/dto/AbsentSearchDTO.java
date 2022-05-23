package com.enigma.salaryapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class AbsentSearchDTO {
    private String idCustomer;
    private LocalDateTime timeOut;
    private LocalDateTime timeIn;
}
