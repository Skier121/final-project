package by.baranov.webproject.util;

import org.apache.commons.codec.digest.DigestUtils;

public class PasswordHash {
    public static String doHashForPassword(String password){
        String result;
        result=DigestUtils.md5Hex(password);
        return result;
    }
}
