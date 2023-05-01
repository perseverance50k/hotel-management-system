package com.hotel.managementsystem.models.employees.cleaners;

public enum DayOfWeek {
    SUNDAY("SUNDAY"),
    MONDAY("MONDAY"),
    TUESDAY("TUESDAY"),
    WEDNESDAY("WEDNESDAY"),
    THURSDAY("THURSDAY"),
    FRIDAY("FRIDAY"),
    SATURDAY("SATURDAY");

    public final String weekDay;

    DayOfWeek(String weekDay) {
        this.weekDay = weekDay;
    }

}
