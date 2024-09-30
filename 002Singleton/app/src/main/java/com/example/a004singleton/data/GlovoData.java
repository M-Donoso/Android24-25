package com.example.a004singleton.data;

public class GlovoData {
    private static String email;
    // private static User user;

    public static String getEmail() {
        return email;
    }
    public static void setEmail(String email) {
        GlovoData.email = email;
    }
}
