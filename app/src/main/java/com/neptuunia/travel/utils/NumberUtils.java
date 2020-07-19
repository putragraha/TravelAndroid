package com.neptuunia.travel.utils;

public class NumberUtils {

    private NumberUtils() {
        // Prevent outside instantion
    }

    public static String getTwoDigitsNumber(int number) {
        return number < 10 ? "0" + number : String.valueOf(number);
    }
}