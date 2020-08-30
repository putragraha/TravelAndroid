package com.neptuunia.data.driver.model.request;

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
