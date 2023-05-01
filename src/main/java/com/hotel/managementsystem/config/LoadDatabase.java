package com.hotel.managementsystem.config;

import com.hotel.managementsystem.models.employees.cleaners.Cleaner;
import com.hotel.managementsystem.models.employees.cleaners.CleanerScheduleRecord;
import com.hotel.managementsystem.models.employees.cleaners.DayOfWeek;
import com.hotel.managementsystem.models.rooms.Room;
import com.hotel.managementsystem.models.rooms.RoomType;
import com.hotel.managementsystem.repository.CleanerRepository;
import com.hotel.managementsystem.repository.CleanerScheduleRecordRepository;
import com.hotel.managementsystem.repository.RoomRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(CleanerRepository cleanerRepository,
                                   RoomRepository roomRepository,
                                   CleanerScheduleRecordRepository cleanerScheduleRecordRepository) {

        /* HOTEL CLEANERS */
        Cleaner cleaner1 = new Cleaner(1L, "John", "", "Doe");
        Cleaner cleaner2 = new Cleaner(2L, "Petro", "Olehovich", "Petrov");
        Cleaner cleaner3 = new Cleaner(3L, "Karl", "", "Johnson");

        /* ROOMS ON THE FLOOR #1 */
        Room floor1_room1 = new Room(101, "155-44-33", RoomType.ONE_GUEST, true);
        Room floor1_room2 = new Room(102, "111-22-33", RoomType.ONE_GUEST, true);
        Room floor1_room3 = new Room(103, "124-54-22", RoomType.ONE_GUEST, true);
        Room floor1_room4 = new Room(104, "125-43-22", RoomType.TWO_GUESTS, true);
        Room floor1_room5 = new Room(105, "123-65-93", RoomType.TWO_GUESTS, true);
        Room floor1_room6 = new Room(106, "173-43-32", RoomType.TWO_GUESTS, true);
        Room floor1_room7 = new Room(107, "184-77-22", RoomType.THREE_GUESTS, true);
        Room floor1_room8 = new Room(108, "164-29-54", RoomType.THREE_GUESTS, true);
        Room floor1_room9 = new Room(109, "175-88-99", RoomType.THREE_GUESTS, true);

        /* ROOMS ON THE FLOOR #2 */
        Room floor2_room1 = new Room(201, "237-44-33", RoomType.ONE_GUEST, true);
        Room floor2_room2 = new Room(202, "211-22-33", RoomType.ONE_GUEST, true);
        Room floor2_room3 = new Room(203, "224-54-22", RoomType.ONE_GUEST, true);
        Room floor2_room4 = new Room(204, "225-43-22", RoomType.TWO_GUESTS, true);
        Room floor2_room5 = new Room(205, "223-65-93", RoomType.TWO_GUESTS, true);
        Room floor2_room6 = new Room(206, "273-43-32", RoomType.TWO_GUESTS, true);
        Room floor2_room7 = new Room(207, "284-77-22", RoomType.THREE_GUESTS, true);
        Room floor2_room8 = new Room(208, "264-29-54", RoomType.THREE_GUESTS, true);
        Room floor2_room9 = new Room(209, "275-88-99", RoomType.THREE_GUESTS, true);

        /* ROOMS ON THE FLOOR #3 */
        Room floor3_room1 = new Room(301, "355-44-33", RoomType.ONE_GUEST, true);
        Room floor3_room2 = new Room(302, "311-22-33", RoomType.ONE_GUEST, true);
        Room floor3_room3 = new Room(303, "324-54-22", RoomType.ONE_GUEST, true);
        Room floor3_room4 = new Room(304, "325-43-22", RoomType.TWO_GUESTS, true);
        Room floor3_room5 = new Room(305, "323-65-93", RoomType.TWO_GUESTS, true);
        Room floor3_room6 = new Room(306, "373-43-32", RoomType.TWO_GUESTS, true);
        Room floor3_room7 = new Room(307, "384-77-22", RoomType.THREE_GUESTS, true);
        Room floor3_room8 = new Room(308, "364-29-54", RoomType.THREE_GUESTS, true);
        Room floor3_room9 = new Room(309, "375-88-99", RoomType.THREE_GUESTS, true);

        /* CLEANERS' SCHEDULE RECORDS */
        CleanerScheduleRecord record1 = new CleanerScheduleRecord(cleaner1, DayOfWeek.SUNDAY, 1);
        CleanerScheduleRecord record2 = new CleanerScheduleRecord(cleaner1, DayOfWeek.MONDAY, 2);
        CleanerScheduleRecord record3 = new CleanerScheduleRecord(cleaner1, DayOfWeek.TUESDAY, 3);
        CleanerScheduleRecord record4 = new CleanerScheduleRecord(cleaner1, DayOfWeek.WEDNESDAY, 1);
        CleanerScheduleRecord record5 = new CleanerScheduleRecord(cleaner1, DayOfWeek.THURSDAY, 2);
        CleanerScheduleRecord record6 = new CleanerScheduleRecord(cleaner1, DayOfWeek.FRIDAY, 3);
        CleanerScheduleRecord record7 = new CleanerScheduleRecord(cleaner1, DayOfWeek.SATURDAY, 1);

        CleanerScheduleRecord record8 = new CleanerScheduleRecord(cleaner2, DayOfWeek.SUNDAY, 3);
        CleanerScheduleRecord record9 = new CleanerScheduleRecord(cleaner2, DayOfWeek.MONDAY, 1);
        CleanerScheduleRecord record10 = new CleanerScheduleRecord(cleaner2, DayOfWeek.TUESDAY, 2);
        CleanerScheduleRecord record11 = new CleanerScheduleRecord(cleaner2, DayOfWeek.WEDNESDAY, 3);
        CleanerScheduleRecord record12 = new CleanerScheduleRecord(cleaner2, DayOfWeek.THURSDAY, 1);
        CleanerScheduleRecord record13 = new CleanerScheduleRecord(cleaner2, DayOfWeek.FRIDAY, 2);
        CleanerScheduleRecord record14 = new CleanerScheduleRecord(cleaner2, DayOfWeek.SATURDAY, 3);

        CleanerScheduleRecord record15 = new CleanerScheduleRecord(cleaner3, DayOfWeek.SUNDAY, 2);
        CleanerScheduleRecord record16 = new CleanerScheduleRecord(cleaner3, DayOfWeek.MONDAY, 3);
        CleanerScheduleRecord record17 = new CleanerScheduleRecord(cleaner3, DayOfWeek.TUESDAY, 1);
        CleanerScheduleRecord record18 = new CleanerScheduleRecord(cleaner3, DayOfWeek.WEDNESDAY, 2);
        CleanerScheduleRecord record19 = new CleanerScheduleRecord(cleaner3, DayOfWeek.THURSDAY, 3);
        CleanerScheduleRecord record20 = new CleanerScheduleRecord(cleaner3, DayOfWeek.FRIDAY, 1);
        CleanerScheduleRecord record21 = new CleanerScheduleRecord(cleaner3, DayOfWeek.SATURDAY, 2);

        return args -> {
            cleanerRepository.saveAll(Arrays.asList(cleaner1, cleaner2, cleaner3));

            roomRepository.saveAll(Arrays.asList(floor1_room1, floor1_room2, floor1_room3, floor1_room4, floor1_room5, floor1_room6, floor1_room7, floor1_room8, floor1_room9));
            roomRepository.saveAll(Arrays.asList(floor2_room1, floor2_room2, floor2_room3, floor2_room4, floor2_room5, floor2_room6, floor2_room7, floor2_room8, floor2_room9));
            roomRepository.saveAll(Arrays.asList(floor3_room1, floor3_room2, floor3_room3, floor3_room4, floor3_room5, floor3_room6, floor3_room7, floor3_room8, floor3_room9));

            cleanerScheduleRecordRepository.saveAll(Arrays.asList(record1, record2, record3, record4, record5, record6, record7, record8, record9, record10, record11,
                    record12, record13, record14, record15, record16, record17, record18, record19, record20, record21));
        };
    }
}
