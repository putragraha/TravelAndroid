package com.neptuunia.data.user.model.request;

/**
 * @author Putra Nugraha (putra.nugraha@dana.id)
 * @version RegisterUserRequest, v 0.0.1 20/08/20 15.31 by Putra Nugraha
 */
public class RegisterUserRequest {

    private String userName;

    private String email;

    private String password;

    private String phoneNumber;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
