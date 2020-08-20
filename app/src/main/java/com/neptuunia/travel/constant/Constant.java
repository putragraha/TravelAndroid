package com.neptuunia.travel.constant;

import com.neptuunia.travel.BuildConfig;

public class Constant {

    public static final String HISTORY_DRIVER_RESPONSE_DATA = "HistoryDriverResponse";

    public static final String HISTORY_USER_RESPONSE_DATA = "HistoryUserResponse";

    public static final String TICKET_RESPONSE_DATA = "TicketResponse";

    public static final String API_URL = BuildConfig.BASE_URL + "/project_travel/api/";

    public static final String IMAGE_URL = BuildConfig.BASE_URL + "/project_travel/upload/foto%20driver/";

    public static final String SP_NAME = "cache";

    private Constant() {
        // Prevent instantiation
    }
}
