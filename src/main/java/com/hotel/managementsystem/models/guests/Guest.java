package com.hotel.managementsystem.models.guests;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity(name = "guest")
public class Guest {

    @Id
    @GeneratedValue
    @Column(name = "guest_id")
    private Integer guestID;

    @Column(name = "room_id", nullable = false)
    private Integer roomID;

    @Column(name = "passport_number", nullable = false)
    private String passportNumber;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "middle_name")
    private String middleName; // will be optional

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "arrived_from_city")
    private String arrivedFromCity;

    @Column(name = "check_in_date", nullable = false)
    private LocalDate checkInDate;

    @Column(name = "check_out_date", nullable = false)
    private LocalDate checkOutDate;

}
