package com.neptuunia.data.user.model.response;

/**
 * @author Putra Nugraha (putra.nugraha@dana.id)
 * @version LoginUserResponse, v 0.0.1 19/08/20 08.53 by Putra Nugraha
 */
public class LoginUserResponse {

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
