package sample;

//Oğulcan Şahin 170503007

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class Password {
    public static String getSHA512Password(String passwordToEncrypt, byte[] salt)
    {
        String generatedPassword = null;

        try
        {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(salt);

            byte[] bytes = md.digest(passwordToEncrypt.getBytes());

            StringBuilder sb = new StringBuilder();

            for (int i=0; i < bytes.length; i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        }
        catch (NoSuchAlgorithmException e)
        {
            System.err.println(e.getMessage());
        }

        return generatedPassword;
    }

    public static byte[] getSalt() throws NoSuchAlgorithmException
    {
        SecureRandom sr = SecureRandom.getInstanceStrong();
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        return salt;
    }
}

