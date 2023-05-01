package com.hotel.managementsystem.service;

import com.hotel.managementsystem.exceptions.CleanerNotFoundException;
import com.hotel.managementsystem.models.employees.cleaners.Cleaner;
import com.hotel.managementsystem.models.employees.cleaners.DayOfWeek;
import com.hotel.managementsystem.repository.CleanerRepository;
import com.hotel.managementsystem.repository.CleanerScheduleRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CleanerService {

    private final CleanerRepository cleanerRepository;
    private final CleanerScheduleRecordRepository scheduleRecordRepository;

    @Autowired
    public CleanerService(CleanerRepository cleanerRepository, CleanerScheduleRecordRepository scheduleRecordRepository) {
        this.cleanerRepository = cleanerRepository;
        this.scheduleRecordRepository = scheduleRecordRepository;
    }

    public Cleaner getCleanerByFloorAndDay(DayOfWeek dayOfWeek, Integer floorNumber) {
        Optional<Cleaner> targetCleaner = cleanerRepository.findCleanerByFloorAndDay(dayOfWeek, floorNumber);

        if (targetCleaner.isEmpty()) {
            throw new CleanerNotFoundException(String.format("Cleaner that cleaned the floor %s on %s not found", floorNumber, dayOfWeek));
        }

        return targetCleaner.get();
    }

    public void hireNewCleaner(Cleaner cleaner) {
        cleanerRepository.save(cleaner);
    }

    public void layOffCleaner(Cleaner cleaner) {
        cleanerRepository.delete(cleaner);
    }

    public void changeCleanerSchedule(Cleaner cleaner, DayOfWeek dayOfWeek, Integer floorNumber) {
        scheduleRecordRepository.updateRecord(cleaner.getCleanerID(), dayOfWeek, floorNumber);
    }
}
