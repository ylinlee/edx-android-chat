package edu.galileo.android.androidchat.domain;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Usuario on 18/07/2016.
 */
public class AvatarHelper {
    private final static String GRAVATAR_URL = "https://s.gravatar.com/avatar/";

    public static String getAvatarUrl(String email){
        return GRAVATAR_URL + md5(email) + "?s=72";
    }

    private static final String md5(final String s) {
        final String MD5 = "MD5";
        try {
            //Create MD5 Hash
            MessageDigest digest = java.security.MessageDigest.getInstance(MD5);
            digest.update(s.getBytes());
            byte messaDigest[] = digest.digest();

            //Create Hex String
            StringBuilder hexString = new StringBuilder();
            for(byte aMessageDigest : messaDigest){
                String h = Integer.toHexString(0xFF & aMessageDigest);
                while(h.length() > 2 ){
                    h = "0" + h;
                }
                hexString.append(h);
                return hexString.toString();
            }
        } catch(NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        return "";
    }
}
