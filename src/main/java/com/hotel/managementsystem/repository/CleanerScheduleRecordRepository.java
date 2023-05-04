package com.hotel.managementsystem.repository;

import com.hotel.managementsystem.models.employees.cleaners.CleanerScheduleRecord;
import com.hotel.managementsystem.models.employees.cleaners.DayOfWeek;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CleanerScheduleRecordRepository extends JpaRepository<CleanerScheduleRecord, Integer> {

    @Modifying
    @Transactional
    @Query(value = "UPDATE hotel_management_system.cleaner_schedule_record SET cleaner_cleaner_id=?1 " +
            "WHERE week_day=?2 AND floor_number=?3", nativeQuery = true)
    Integer updateRecord(Integer cleanerID, String newDay, Integer newFloorNumber);

}
