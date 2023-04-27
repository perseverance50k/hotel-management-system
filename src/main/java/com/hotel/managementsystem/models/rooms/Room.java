package com.hotel.managementsystem.models.rooms;

import jakarta.persistence.*;

@Entity(name = "room")
public class Room {

    @Id
    @GeneratedValue
    @Column(name = "room_id")
    private Integer roomID;

    @Column(name = "tel_number", nullable = false)
    private String telephoneNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "type",  nullable = false)
    private RoomType type;

    @Column(name = "is_available", nullable = false)
    private Boolean isAvailable;

}
