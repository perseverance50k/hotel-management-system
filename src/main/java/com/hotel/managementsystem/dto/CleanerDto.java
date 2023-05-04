package com.hotel.managementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CleanerDto {
    private Integer cleanerID;
    private String firstName;
    private String middleName;
    private String lastName;
}
