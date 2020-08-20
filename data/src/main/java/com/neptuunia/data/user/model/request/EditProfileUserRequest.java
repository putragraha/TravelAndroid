package com.neptuunia.data.user.model.request;

/**
 * @author Putra Nugraha (putra.nugraha@dana.id)
 * @version EditProfileDriverRequest, v 0.0.1 20/08/20 08.26 by Putra Nugraha
 */
public class EditProfileUserRequest {

    private int id;

    private String name;

    private String email;

    private String phoneNumber;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
