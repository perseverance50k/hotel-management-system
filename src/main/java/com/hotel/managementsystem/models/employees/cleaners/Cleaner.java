package com.hotel.managementsystem.models.employees.cleaners;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "cleaner")
public class Cleaner {

    @Id
    @GeneratedValue
    @Column(name = "cleaner_id")
    private Long cleanerID;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @OneToMany(mappedBy = "cleaner", cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<CleanerScheduleRecord> scheduleRecords = new ArrayList<>();

    public Cleaner() {
    }

    public Cleaner(Long cleanerID, String firstName, String middleName, String lastName) {
        this.cleanerID = cleanerID;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    public Long getCleanerID() {
        return cleanerID;
    }

    @Override
    public String toString() {
        return "Cleaner{" +
                "\n\tcleanerID=" + cleanerID +
                ", \n\tfirstName='" + firstName + '\'' +
                ", \n\tmiddleName='" + middleName + '\'' +
                ", \n\tlastName='" + lastName + '\'' +
                ", \n\tscheduleRecords=" + scheduleRecords +
                '}';
    }
}
