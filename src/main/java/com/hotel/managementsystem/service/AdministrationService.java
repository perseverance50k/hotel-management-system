package com.hotel.managementsystem.service;

import com.hotel.managementsystem.dto.CleanerDto;
import com.hotel.managementsystem.dto.GuestDto;
import com.hotel.managementsystem.exceptions.NoAvailableRoomTypeException;
import com.hotel.managementsystem.models.employees.cleaners.Cleaner;
import com.hotel.managementsystem.models.guests.Guest;
import com.hotel.managementsystem.models.rooms.RoomType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<GuestDto> getGuestsInfoByRoomNumber(Integer roomNumber) {
        List<GuestDto> guests = guestService.getGuestsInfoByRoom(roomNumber)
                                            .stream()
                                            .map(this::mapToGuestDto)
                                            .collect(Collectors.toList());
        return guests;
    }

    public List<GuestDto> getGuestsInfoByCity(String city) {
        List<GuestDto> guests = guestService.getGuestsByCity(city)
                                            .stream()
                                            .map(this::mapToGuestDto)
                                            .collect(Collectors.toList());
        return guests;
    }

    public CleanerDto getCleanerInfoByDayAndFloor(String day, Integer floorNumber) {
        return mapToCleanerDto(cleanerService.getCleanerByFloorAndDay(day, floorNumber));
    }

    public boolean areThereAvailableRooms() {
        return roomService.areThereAvailableRooms();
    }

    public Long getNumberOfAvailableRooms() {
        return roomService.getNumberOfAvailableRooms();
    }

    public List<CleanerDto> getAllCleaners() {
        return mapToListOfCleanerDtos(cleanerService.getAllCleaners());
    }

    public void hireCleaner(CleanerDto cleanerDto) {
        cleanerService.hireNewCleaner(mapToCleaner(cleanerDto));
    }

    public void layOffCleanerById(Integer cleanerID) {
        cleanerService.layOffCleanerById(cleanerID);
    }

    public void changeCleanerSchedule(Integer cleanerID, String day, Integer floorNumber) {
        cleanerService.changeCleanerSchedule(cleanerID, day, floorNumber);
    }

    public void checkInGuests(List<GuestDto> guestDtos) {
        checkInGuestsAndReserveRoom(mapToListOfGuests(guestDtos));
    }

    public void checkOutGuestsByRoomNumber(Integer roomNumber) {
        checkOutGuestsAndFreeUpRoom(roomNumber);
    }

//    public List<GuestDto> getAllGuests() {
//        return guestService.getAllGuests().stream().map(this::mapToGuestDto).collect(Collectors.toList());
//    }

    private void checkInGuestsAndReserveRoom(List<Guest> guests) {
        String suitableRoomType = getSuitableRoomType(guests.size());
        Integer roomNumber = roomService.findFirstAvailableRoomNumberDependingOnType(String.valueOf(suitableRoomType));

        for (Guest guest : guests) {
            guest.setRoomNumber(roomNumber);
        }

        guestService.checkInGuestsInRoom(roomNumber, guests);
        roomService.setAvailableToFalse(roomNumber);

        System.out.println("CHECKED IN – RoomType: " + suitableRoomType + ", roomNumber: " + roomNumber);
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

    private GuestDto mapToGuestDto(Guest guest) {
        GuestDto guestDto = GuestDto.builder()
                .firstName(guest.getFirstName())
                .middleName(guest.getMiddleName())
                .lastName(guest.getLastName())
                .passportNumber(guest.getPassportNumber())
                .checkInDate(guest.getCheckInDate())
                .checkOutDate(guest.getCheckOutDate())
                .arrivedFromCity(guest.getArrivedFromCity())
                .roomNumber(guest.getRoomNumber())
                .build();

        return guestDto;
    }

    private CleanerDto mapToCleanerDto(Cleaner cleaner) {
        CleanerDto cleanerDto = CleanerDto.builder()
                .cleanerID(cleaner.getCleanerID())
                .firstName(cleaner.getFirstName())
                .middleName(cleaner.getMiddleName())
                .lastName(cleaner.getLastName())
                .build();

        return cleanerDto;
    }

    private Guest mapToGuest(GuestDto guestDto) {
        Guest guest = Guest.builder()
                .firstName(guestDto.getFirstName())
                .middleName(guestDto.getMiddleName())
                .lastName(guestDto.getLastName())
                .passportNumber(guestDto.getPassportNumber())
                .arrivedFromCity(guestDto.getArrivedFromCity())
                .checkInDate(guestDto.getCheckInDate())
                .checkOutDate(guestDto.getCheckOutDate())
                .build();

        return guest;
    }

    private List<Guest> mapToListOfGuests(List<GuestDto> guestDtos) {
        return guestDtos.stream().map(this::mapToGuest).collect(Collectors.toList());
    }

    private Cleaner mapToCleaner(CleanerDto cleanerDto) {
        Cleaner cleaner = Cleaner.builder()
                .firstName(cleanerDto.getFirstName())
                .middleName(cleanerDto.getMiddleName())
                .lastName(cleanerDto.getLastName())
                .build();

        return cleaner;
    }

    private List<CleanerDto> mapToListOfCleanerDtos(List<Cleaner> cleaners) {
        return cleaners.stream().map(this::mapToCleanerDto).collect(Collectors.toList());
    }
}
