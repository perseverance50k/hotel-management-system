package com.hotel.managementsystem.controllers;

import com.hotel.managementsystem.dto.CleanerDto;
import com.hotel.managementsystem.dto.GuestDto;
import com.hotel.managementsystem.dto.GuestsCheckInDto;
import com.hotel.managementsystem.service.AdministrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping(path = "/admin")
public class AdministrationController {

    private final AdministrationService administrationService;

    @Autowired
    public AdministrationController(AdministrationService administrationService) {
        this.administrationService = administrationService;
    }

    @GetMapping(path = "/main")
    public String returnMainPage() {
        return "main/index";
    }

    @GetMapping(path = "/availableRoomsInfo")
    public String displayInfoAboutAvailableRooms(Model model) {
        model.addAttribute("areThereAvailableRooms", administrationService.areThereAvailableRooms());
        model.addAttribute("numberOfAvailableRooms", administrationService.getNumberOfAvailableRooms());

        return "rooms/available-rooms";
    }

    @GetMapping(path = "/getCleanerInfo")
    public String getCleanerInfoPage() {
        return "cleaners/cleaner-info-form";
    }

    @GetMapping(path = "/infoAboutCleanerByFloorAndDay")
    public String displayInfoAboutCleanerByFloorAndDay(@RequestParam(name = "floor") int floorNumber,
                                                       @RequestParam(name = "day") String day,
                                                       Model model) {
        model.addAttribute("cleaner", administrationService.getCleanerInfoByDayAndFloor(day, floorNumber));
        model.addAttribute("floorNumber", floorNumber);
        model.addAttribute("day", day);
        return "cleaners/info-about-cleaner";
    }

    @GetMapping(path = "/cleanerPositions")
    public String getHireLayOffCleanerPage(Model model) {
        model.addAttribute("newCleanerDto", new CleanerDto());
        model.addAttribute("cleaners", administrationService.getAllCleaners());
        return "cleaners/cleaners";
    }

    @PostMapping(path = "/hireCleaner")
    public String hireNewCleaner(@ModelAttribute CleanerDto cleanerDto) {
        administrationService.hireCleaner(cleanerDto);
        return "redirect:/admin/cleanerPositions";
    }

    @GetMapping(path = "/layOffCleaner/{cleanerId}")
    public String layOffCleaner(@PathVariable(name = "cleanerId") Integer cleanerID) {
        administrationService.layOffCleanerById(cleanerID);
        return "redirect:/admin/cleanerPositions";
    }

    @GetMapping(path = "/editSchedule/{cleanerId}")
    public String getEditCleanerSchedulePage(@PathVariable(name = "cleanerId") Integer cleanerId, Model model, RedirectAttributes redirectAttributes) {
        model.addAttribute("cleanerId", cleanerId);
        redirectAttributes.addFlashAttribute("cleanerId", cleanerId);
        return "cleaners/change-cleaner-schedule";
    }

    @GetMapping(path = "/editScheduleProcessing")
    public String processEditCleanerSchedule(@RequestParam(name = "day") String day,
                                             @RequestParam(name = "floor") Integer floor,
                                             @RequestParam(name = "cleanerId") Integer cleanerId) {
        administrationService.changeCleanerSchedule(cleanerId, day, floor);

        return "redirect:/admin/cleanerPositions";
    }

    @GetMapping(path = "/checkInCheckOut")
    public String getCheckInCheckOutPage(Model model) {
        GuestsCheckInDto checkInDto = new GuestsCheckInDto();
        checkInDto.setGuestDtoList(List.of(new GuestDto(), new GuestDto(), new GuestDto()));

        model.addAttribute("guestsForm", checkInDto);
        return "guests/check-in-check-out-guests";
    }

    @PostMapping(path = "/checkInProcessing")
    public String processCheckIn(@ModelAttribute GuestsCheckInDto guestsCheckInDto) {
        administrationService.checkInGuests(guestsCheckInDto.getGuestDtoList());
        return "redirect:/admin/checkInCheckOut";
    }

    @GetMapping(path = "checkOutProcessing")
    public String processCheckOut(@RequestParam(name = "room_number") Integer roomNumber) {
        administrationService.checkOutGuestsByRoomNumber(roomNumber);
        return "redirect:/admin/checkInCheckOut";
    }
}
