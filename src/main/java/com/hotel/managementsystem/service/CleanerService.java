package com.hotel.managementsystem.service;

import com.hotel.managementsystem.exceptions.CleanerNotFoundException;
import com.hotel.managementsystem.models.employees.cleaners.Cleaner;
import com.hotel.managementsystem.repository.CleanerRepository;
import com.hotel.managementsystem.repository.CleanerScheduleRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public List<Cleaner> getAllCleaners() {
        return cleanerRepository.findAll();
    }

    public Cleaner getCleanerByFloorAndDay(String dayOfWeek, Integer floorNumber) {
        Optional<Cleaner> targetCleaner = cleanerRepository.findCleanerByFloorAndDay(dayOfWeek.toUpperCase(), floorNumber);

        if (targetCleaner.isEmpty()) {
            throw new CleanerNotFoundException(String.format("Cleaner that cleaned the floor %s on %s not found", floorNumber, dayOfWeek));
        }

        return targetCleaner.get();
    }

    public void hireNewCleaner(Cleaner cleaner) {
        cleanerRepository.save(cleaner);
    }

    public void layOffCleanerById(Integer cleanerID) {
        cleanerRepository.deleteById(cleanerID);
    }

    public void changeCleanerSchedule(Integer cleanerID, String dayOfWeek, Integer floorNumber) {
        scheduleRecordRepository.updateRecord(cleanerID, dayOfWeek.toUpperCase(), floorNumber);
    }

}
