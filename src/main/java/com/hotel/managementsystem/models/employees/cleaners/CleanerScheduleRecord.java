package com.hotel.managementsystem.models.employees.cleaners;

import jakarta.persistence.*;

@Entity(name = "cleaner_schedule_record")
public class CleanerScheduleRecord {

    @Id
    @GeneratedValue
    @Column(name = "record_id")
    private Integer recordID;

    @Column(name = "cleaner_id", nullable = false)
    private Integer cleanerID;

    @Enumerated(EnumType.STRING)
    @Column(name = "week_day", nullable = false)
    private DayOfWeek dayOfWeek;

    @Column(name = "floor_number", nullable = false)
    private Integer floorNumber;

    public CleanerScheduleRecord() {

    }

    public CleanerScheduleRecord(int cleanerID, DayOfWeek dayOfWeek, int floorNumber) {
        this.cleanerID = cleanerID;
        this.dayOfWeek = dayOfWeek;
        this.floorNumber = floorNumber;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public int getCleanerID() {
        return cleanerID;
    }
}
