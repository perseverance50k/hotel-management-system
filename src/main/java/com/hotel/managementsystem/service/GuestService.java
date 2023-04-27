package com.hotel.managementsystem.service;

import com.hotel.managementsystem.models.guests.Guest;
import com.hotel.managementsystem.repository.GuestRepository;
import com.hotel.managementsystem.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestService {

    private final GuestRepository guestRepository;
    private final RoomRepository roomRepository;

    @Autowired
    public GuestService(GuestRepository guestRepository, RoomRepository roomRepository) {
        this.guestRepository = guestRepository;
        this.roomRepository = roomRepository;
    }

    public List<Guest> getGuestsInfoByRoom(Integer roomNumber) {
        return guestRepository.findGuestsByRoomNumber(roomNumber);
    }

    public List<Guest> getGuestsByCity(String city) {
        return guestRepository.findGuestsByCity(city);
    }

    public void checkInGuestsInRoom(Integer roomNumber, Guest... guests) {
        // TODO: create an SQL query for this operation in GuestRepository
    }

    public void checkOutGuestsFromRoom(Integer roomNumber) {
        // TODO: create an SQL query for this operation in GuestRepository
    }
}
