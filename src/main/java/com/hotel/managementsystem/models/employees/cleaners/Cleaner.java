package com.hotel.managementsystem.models.employees.cleaners;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "cleaner")
public class Cleaner {

    @Id
    @GeneratedValue
    @Column(name = "cleaner_id")
    private Integer cleanerID;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CleanerScheduleRecord> scheduleRecords = new ArrayList<>();

}
