package com.hotel.managementsystem.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
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
