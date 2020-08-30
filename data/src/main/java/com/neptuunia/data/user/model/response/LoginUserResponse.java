package com.neptuunia.data.user.model.response;

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
