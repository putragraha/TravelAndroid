package com.neptuunia.travel.utils;

import java.text.DecimalFormat;

public class NumberUtils {

    public static final String IDR_CURRENCY_FORMAT = "Rp ###,###";

    public static final String IDR_ZERO_VALUE = "Rp 0";

    private NumberUtils() {
        // Prevent outside instantion
    }

    public static String getTwoDigitsNumber(int number) {
        return number < 10 ? "0" + number : String.valueOf(number);
    }

    public static String toRupiah(int number) {
        DecimalFormat formatter = new DecimalFormat(IDR_CURRENCY_FORMAT);
        return number > 0 ? formatter.format(number) : IDR_ZERO_VALUE;
    }
}