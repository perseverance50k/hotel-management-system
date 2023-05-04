package com.hotel.managementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GuestDto {
    private Integer roomNumber;
    private String passportNumber;
    private String firstName;
    private String middleName;
    private String lastName;
    private String arrivedFromCity;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
}
