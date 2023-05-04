package com.hotel.managementsystem.service;

import com.hotel.managementsystem.models.guests.Guest;
import com.hotel.managementsystem.repository.GuestRepository;
import com.hotel.managementsystem.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
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

    public void checkInGuestsInRoom(Integer roomNumber, List<Guest> guests) {
        guestRepository.saveAll(guests);
        roomRepository.setIsAvailableFalse(roomNumber);
    }

    public void checkOutGuestsFromRoom(Integer roomNumber) {
        guestRepository.deleteGuestsByRoomNumber(roomNumber);
        roomRepository.setIsAvailableTrue(roomNumber);
    }

//    public List<Guest> getAllGuests() {
//        return guestRepository.findAll();
//    }
}
