package com.neptuunia.data.driver.model.response;

/**
 * @author Putra Nugraha (putra.nugraha@dana.id)
 * @version LoginDriverResponse, v 0.0.1 19/08/20 08.53 by Putra Nugraha
 */
public class LoginDriverResponse {

    private int id;

    private boolean success;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
