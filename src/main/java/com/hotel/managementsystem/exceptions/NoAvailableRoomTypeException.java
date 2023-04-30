package com.hotel.managementsystem.exceptions;

public class NoAvailableRoomTypeException extends IllegalArgumentException {
    public NoAvailableRoomTypeException() {
        super();
    }

    public NoAvailableRoomTypeException(String s) {
        super(s);
    }

    public NoAvailableRoomTypeException(String message, Throwable cause) {
        super(message, cause);
    }
}
