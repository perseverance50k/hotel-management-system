package com.hotel.managementsystem.models.guests;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity(name = "guest")
public class Guest {

    @Id
    @GeneratedValue
    @Column(name = "guest_id")
    private Long guestID;

    @Column(name = "room_number", nullable = false)
    private Integer roomNumber;

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

    public Guest() {
    }

    public Guest(Integer roomNumber, String passportNumber, String firstName,
                 String middleName, String lastName, String arrivedFromCity,
                 LocalDate checkInDate, LocalDate checkOutDate) {
        this.roomNumber = roomNumber;
        this.passportNumber = passportNumber;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.arrivedFromCity = arrivedFromCity;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }
}
