package com.hotel.managementsystem.dto;

import com.hotel.managementsystem.models.employees.cleaners.CleanerScheduleRecord;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class CleanerDto {
    private String firstName;
    private String middleName;
    private String lastName;
    private final List<CleanerScheduleRecord> scheduleRecords = new ArrayList<>();
}
