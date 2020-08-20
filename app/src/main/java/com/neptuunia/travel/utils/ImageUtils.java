package com.neptuunia.travel.utils;

import com.neptuunia.travel.constant.Constant;

/**
 * @author Putra Nugraha (putra.nugraha@dana.id)
 * @version GlideUtils, v 0.0.1 20/08/20 17.16 by Putra Nugraha
 */
public class ImageUtils {

    private ImageUtils() {
        // Prevent outside instantiation
    }

    public static String loadImage(String imageName) {
        String imageFullUrl = Constant.IMAGE_URL + imageName;
        return imageFullUrl.replace(" ", "%20");
    }
}
