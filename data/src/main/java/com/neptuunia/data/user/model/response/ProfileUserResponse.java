package com.neptuunia.data.user.model.response;

/**
 * @author Putra Nugraha (putra.nugraha@dana.id)
 * @version ProfileDriverResponse, v 0.0.1 19/08/20 22.15 by Putra Nugraha
 */
public class ProfileUserResponse {

    private String name;

    private String email;

    private String phoneNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
