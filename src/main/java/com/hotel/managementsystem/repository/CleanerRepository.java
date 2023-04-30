package com.hotel.managementsystem.repository;

import com.hotel.managementsystem.models.employees.cleaners.Cleaner;
import com.hotel.managementsystem.models.employees.cleaners.DayOfWeek;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CleanerRepository extends JpaRepository<Cleaner, Integer> {

    @Query(value = "SELECT * FROM cleaner clnr JOIN cleaner_schedule_record csr on clnr.cleaner_id = csr.cleaner_id" +
            " WHERE csr.floor_number=?1 AND csr.week_day=?2;", nativeQuery = true)
    Optional<Cleaner> findCleanerByFloorAndDay(Integer floorNumber, DayOfWeek day);
}
