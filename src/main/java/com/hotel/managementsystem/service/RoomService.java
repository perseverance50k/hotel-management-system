package com.hotel.managementsystem.service;

import com.hotel.managementsystem.exceptions.NoAvailableRoomTypeException;
import com.hotel.managementsystem.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService {

    private final RoomRepository roomRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public boolean areThereAvailableRooms() {
        return roomRepository.getNumberOfRoomsAvailable() > 0;
    }

    public Long getNumberOfAvailableRooms() {
        return roomRepository.getNumberOfRoomsAvailable();
    }

    public void setAvailableToTrue(Integer roomNumber) {
        roomRepository.setIsAvailableTrue(roomNumber);
    }

    public void setAvailableToFalse(Integer roomNumber) {
        roomRepository.setIsAvailableFalse(roomNumber);
    }

    public Integer findFirstAvailableRoomNumberDependingOnType(String roomType) {

        Integer roomNumber = roomRepository.findFirstAvailableRoomNumberByType(roomType);

        if (roomNumber == null) {
            throw new NoAvailableRoomTypeException(String.format("There is no available room of type %s!", roomType));
        }

        return roomNumber;
    }
}
