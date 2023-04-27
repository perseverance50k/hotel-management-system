package com.hotel.managementsystem.repository;

import com.hotel.managementsystem.models.guests.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GuestRepository extends JpaRepository<Guest, Integer> {

    @Query(value = "SELECT * FROM guest gst WHERE gst.arrived_from_city=?1;", nativeQuery = true)
    List<Guest> findGuestsByCity(String city);

    @Query(value = "SELECT * FROM guest gst WHERE gst.room_id=?1;", nativeQuery = true)
    List<Guest> findGuestsByRoomNumber(Integer roomNumber);

}
