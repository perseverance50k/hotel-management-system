package com.hotel.managementsystem.models.employees.cleaners;

import jakarta.persistence.*;

@Entity(name = "cleaner_schedule_record")
public class CleanerScheduleRecord {

    @Id
    @GeneratedValue
    @Column(name = "record_id")
    private Long recordID;

    @ManyToOne(fetch = FetchType.LAZY)
    private Cleaner cleaner;

    @Enumerated(EnumType.STRING)
    @Column(name = "week_day", nullable = false)
    private DayOfWeek dayOfWeek;

    @Column(name = "floor_number", nullable = false)
    private Integer floorNumber;

    public CleanerScheduleRecord() {

    }

    public CleanerScheduleRecord(Cleaner cleaner, DayOfWeek dayOfWeek, Integer floorNumber) {
        this.cleaner = cleaner;
        this.dayOfWeek = dayOfWeek;
        this.floorNumber = floorNumber;
    }

    @Override
    public String toString() {
        return "Record: " +
                " dayOfWeek=" + dayOfWeek +
                ", floorNumber=" + floorNumber;
    }
}
