package com.example.urlshortener.util;


import java.nio.charset.StandardCharsets;

public class Util {

    public static String getRandomString() {
        String random = "";
        String possibleChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        for (int i = 0; i < 5; i++)
            random += possibleChars.charAt((int) Math.floor(Math.random() * possibleChars.length()));
        return random;
    }
}
