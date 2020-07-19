package com.neptuunia.travel.utils;

/**
 * @author Putra Nugraha (putra.nugraha@dana.id)
 * @version NumberUtils, v 0.0.1 19/07/20 13.10 by Putra Nugraha
 */
public class NumberUtils {

    private NumberUtils() {
        // Prevent outside instantion
    }

    public static String getTwoDigitsNumber(int number) {
        return number < 10 ? "0" + number : String.valueOf(number);
    }
}