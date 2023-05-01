package com.hotel.managementsystem.repository;

import com.hotel.managementsystem.models.rooms.Room;
import com.hotel.managementsystem.models.rooms.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {

    @Query(value = "SELECT COUNT(is_available) FROM room rm WHERE rm.is_available=true", nativeQuery = true)
    Long getNumberOfRoomsAvailable();

    @Query(value = "UPDATE room SET is_available=false WHERE number=?1", nativeQuery = true)
    void setIsAvailableFalse(Integer roomNumber);

    @Query(value = "UPDATE room SET is_available=true WHERE number=?1", nativeQuery = true)
    void setIsAvailableTrue(Integer roomNumber);

    @Query(value = "SELECT number FROM room WHERE type=?1 LIMIT 1", nativeQuery = true)
    Integer findFirstAvailableRoomNumberByType(RoomType type);
}
