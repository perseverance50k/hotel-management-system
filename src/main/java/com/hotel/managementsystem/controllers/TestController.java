package com.hotel.managementsystem.controllers;

import com.hotel.managementsystem.service.AdministrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
        System.out.println(administrationService.areThereAvailableRooms());
        System.out.println(administrationService.getCleanerInfoByDayAndFloor("MONDAY", 3));
        return "hello";
    }
}
