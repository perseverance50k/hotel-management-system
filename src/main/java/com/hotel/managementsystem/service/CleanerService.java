package com.hotel.managementsystem.service;

import com.hotel.managementsystem.exceptions.CleanerNotFoundException;
import com.hotel.managementsystem.models.employees.cleaners.Cleaner;
import com.hotel.managementsystem.models.employees.cleaners.DayOfWeek;
import com.hotel.managementsystem.repository.CleanerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CleanerService {

    private final CleanerRepository cleanerRepository;

    @Autowired
    public CleanerService(CleanerRepository cleanerRepository) {
        this.cleanerRepository = cleanerRepository;
    }

    public Cleaner getCleanerByFloorAndDay(Integer floorNumber, DayOfWeek dayOfWeek) {
        Optional<Cleaner> targetCleaner = cleanerRepository.findCleanerByFloorAndDay(floorNumber, dayOfWeek);

        if (targetCleaner.isEmpty()) {
            throw new CleanerNotFoundException(String.format("Cleaner that cleaned the floor %s on %s not found", floorNumber, dayOfWeek));
        }

        return targetCleaner.get();
    }

    public void hireNewCleaner(Cleaner cleaner) {
        // TODO: Create an SQL query for this operation in CleanerRepository
    }

    public void layOffCleaner(Cleaner cleaner) {
        // TODO: Create an SQL query for this operation in CleanerRepository
    }

    public void changeCleanerSchedule(Cleaner cleaner, Integer floorNumber, DayOfWeek dayOfWeek) {
        // TODO: Create an SQL query for this operation in CleanerRepository
    }
}
