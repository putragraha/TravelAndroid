package com.neptuunia.data.driver.model;

/**
 * @author Putra Nugraha (putra.nugraha@dana.id)
 * @version LoginDriverRequest, v 0.0.1 19/08/20 08.39 by Putra Nugraha
 */
public class LoginDriverRequest {

    private String email;

    private String password;

    public LoginDriverRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
