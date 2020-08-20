package com.neptuunia.data.user.model.request;

/**
 * @author Putra Nugraha (putra.nugraha@dana.id)
 * @version LoginDriverRequest, v 0.0.1 19/08/20 08.39 by Putra Nugraha
 */
public class LoginUserRequest {

    private String email;

    private String password;

    public LoginUserRequest(String email, String password) {
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
