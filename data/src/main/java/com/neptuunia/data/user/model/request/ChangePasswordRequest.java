package com.neptuunia.data.user.model.request;

/**
 * @author Putra Nugraha (putra.nugraha@dana.id)
 * @version ChangePasswordRequest, v 0.0.1 20/08/20 16.03 by Putra Nugraha
 */
public class ChangePasswordRequest {

    private int id;

    private String newPassword;

    private String oldPassword;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }
}
