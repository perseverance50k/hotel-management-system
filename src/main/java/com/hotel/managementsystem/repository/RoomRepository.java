package com.hotel.managementsystem.repository;

import com.hotel.managementsystem.models.rooms.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {

    @Query(value = "SELECT CAST(CASE WHEN COUNT(*) > 0 THEN 1 ELSE 0 END AS BINARY) " +
            "FROM room rm WHERE rm.is_available = 1;", nativeQuery = true)
    Boolean areThereAvailableRooms();

    @Query(value = "SELECT COUNT(*) FROM room;", nativeQuery = true)
    Long getNumberOfRoomsAvailable();
}
