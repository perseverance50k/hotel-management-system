package com.hotel.managementsystem.service;

import com.hotel.managementsystem.exceptions.NoAvailableRoomTypeException;
import com.hotel.managementsystem.models.employees.cleaners.Cleaner;
import com.hotel.managementsystem.models.employees.cleaners.DayOfWeek;
import com.hotel.managementsystem.models.guests.Guest;
import com.hotel.managementsystem.models.rooms.RoomType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministrationService {

    private final CleanerService cleanerService;
    private final GuestService guestService;
    private final RoomService roomService;

    @Autowired
    public AdministrationService(CleanerService cleanerService, GuestService guestService, RoomService roomService) {
        this.cleanerService = cleanerService;
        this.guestService = guestService;
        this.roomService = roomService;
    }

    public List<Guest> getGuestsInfoByRoomNumber(Integer roomNumber) {
        return guestService.getGuestsInfoByRoom(roomNumber);
    }

    public List<Guest> getGuestsInfoByCity(String city) {
        return guestService.getGuestsByCity(city);
    }

    public Cleaner getCleanerInfoByDayAndFloor(String day, Integer floorNumber) {
        return cleanerService.getCleanerByFloorAndDay(DayOfWeek.valueOf(day), floorNumber);
    }

    public boolean areThereAvailableRooms() {
        return roomService.areThereAvailableRooms();
    }

    public Long getNumberOfAvailableRooms() {
        return roomService.getNumberOfAvailableRooms();
    }

    public void hireCleaner(Cleaner cleaner) {
        cleanerService.hireNewCleaner(cleaner);
    }

    public void layOffCleaner(Cleaner cleaner) {
        cleanerService.layOffCleaner(cleaner);
    }

    public void changeCleanerSchedule(Cleaner cleaner, String day, Integer floorNumber) {
        cleanerService.changeCleanerSchedule(cleaner, DayOfWeek.valueOf(day), floorNumber);
    }

    public void checkInGuests(Guest... guests) {
        checkInGuestsAndReserveRoom(guests);
    }

    public void checkOutGuestsByRoomNumber(Integer roomNumber) {
        checkOutGuestsAndFreeUpRoom(roomNumber);
    }

    private void checkInGuestsAndReserveRoom(Guest... guests) {
        String suitableRoomType = getSuitableRoomType(guests.length);
        Integer roomNumber = roomService.findFirstAvailableRoomNumberDependingOnType(String.valueOf(suitableRoomType));
        guestService.checkInGuestsInRoom(roomNumber, guests);
        roomService.setAvailableToFalse(roomNumber);
    }

    private String getSuitableRoomType(int numberOfGuests) {
        return switch (numberOfGuests) {
            case (1) -> String.valueOf(RoomType.ONE_GUEST);
            case (2) -> String.valueOf(RoomType.TWO_GUESTS);
            case (3) -> String.valueOf(RoomType.THREE_GUESTS);
            default ->
                    throw new NoAvailableRoomTypeException(String.format("There is no room for %s guests!", numberOfGuests));
        };
    }

    private void checkOutGuestsAndFreeUpRoom(Integer roomNumber) {
        guestService.checkOutGuestsFromRoom(roomNumber);
        roomService.setAvailableToTrue(roomNumber);
    }
}
