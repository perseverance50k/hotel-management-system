package com.hotel.managementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class GuestsCheckInDto {

    private List<GuestDto> guestDtoList;

    public void addGuestDto(GuestDto guestDto) {
        guestDtoList.add(guestDto);
    }

}
