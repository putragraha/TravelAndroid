package com.neptuunia.travel.utils;

import com.neptuunia.travel.constant.Constant;

public class ImageUtils {

    private ImageUtils() {
        // Prevent outside instantiation
    }

    public static String getDriverFullUrl(String imageName) {
        String imageFullUrl = Constant.DRIVER_IMAGE_URL + imageName;
        return imageFullUrl.replace(" ", "%20");
    }

    public static String getCarFullUrl(String imageName) {
        String imageFullUrl = Constant.CAR_IMAGE_URL + imageName;
        return imageFullUrl.replace(" ", "%20");
    }
}
