package by.baranov.webproject.util;

import java.security.SecureRandom;

public class PasswordGenerator {
    private static final String DICTIONARY = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*_=+-/";
    private final static int PASSWORD_LENGTH=10;
    private static SecureRandom random = new SecureRandom();

    public static String generatePassword() {
        String result = "";
        for (int i = 0; i < PASSWORD_LENGTH; i++) {
            int index = random.nextInt(DICTIONARY.length());
            result += DICTIONARY.charAt(index);
        }
        return result;
    }
}
