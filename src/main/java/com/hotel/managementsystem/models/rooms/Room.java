package com.hotel.managementsystem.models.rooms;

import jakarta.persistence.*;

@Entity(name = "room")
public class Room {

    @Id
    @GeneratedValue
    @Column(name = "room_id")
    private Long roomID;

    @Column(name = "number")
    private Integer roomNumber;

    @Column(name = "tel_number", nullable = false)
    private String telephoneNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "type",  nullable = false)
    private RoomType type;

    @Column(name = "is_available", nullable = false)
    private Boolean isAvailable;

    @Column(name = "price", nullable = false)
    private Double price;

    public Room() {
    }

    public Room(Integer roomNumber, String telephoneNumber, RoomType type, Boolean isAvailable, Double price) {
        this.roomNumber = roomNumber;
        this.telephoneNumber = telephoneNumber;
        this.type = type;
        this.isAvailable = isAvailable;
        this.price = price;
    }
}
