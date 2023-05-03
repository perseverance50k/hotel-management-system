package com.hotel.managementsystem.controllers;

import com.hotel.managementsystem.models.guests.Guest;
import com.hotel.managementsystem.service.AdministrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping(path = "/test")
public class TestController {

    private final AdministrationService administrationService;

    @Autowired
    public TestController(AdministrationService administrationService) {
        this.administrationService = administrationService;
    }

    @GetMapping(path = "/")
    public String areThereAvailableRooms() {
        System.out.println("ARE THERE AVAILABLE ROOMS:\n " + administrationService.areThereAvailableRooms());
        System.out.println("CLEANER THAT WORKED ON THE THIRD FLOOR ON MONDAY:\n " + administrationService.getCleanerInfoByDayAndFloor("MONDAY", 3));
        System.out.println("NUMBER OF AVAILABLE ROOMS: " + administrationService.getNumberOfAvailableRooms());

        Guest guest1 = new Guest("Serhii", "Olexandrovich", "Chernikov", "FD-30124", "Chicago", LocalDate.now(), LocalDate.now().plusDays(7));
        Guest guest2 = new Guest("Some", "Awesome", "Person", "LD-43532", "Chicago", LocalDate.now(), LocalDate.now().plusDays(7));

        administrationService.checkInGuests(List.of(guest1, guest2));

        System.out.println("NUMBER OF AVAILABLE ROOMS AFTER CHECK IN: " + administrationService.getNumberOfAvailableRooms());
        System.out.println("GUESTS FROM CHICAGO:\n" + administrationService.getGuestsInfoByCity("Chicago"));

        System.out.println("GUESTS FROM ROOM 104:\n" + administrationService.getGuestsInfoByRoomNumber(104));

        return "hello";
    }
}
