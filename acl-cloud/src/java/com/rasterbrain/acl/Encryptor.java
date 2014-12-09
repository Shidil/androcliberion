/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rasterbrain.acl;

/**
 *
 * @author Shidil Boss
 */
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class Encryptor {

    String key = "assassin20sASP22"; // 128 bit key
    Key aesKey;
    Cipher cipher;

    public Encryptor() {
        // Create key and cipher
        aesKey = new SecretKeySpec(key.getBytes(), "AES");
        try {
            cipher = Cipher.getInstance("AES");
        } catch (NoSuchAlgorithmException | NoSuchPaddingException ex) {
            Logger.getLogger(Encryptor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        String text = enCrypt("SHIDIL");
        System.out.println("Encrypted - "+text);       
        System.out.println("Decrypted - "+deCrypt(text));
    }

    public String enCrypt(String text) {
        try {

            // encrypt the text
            cipher.init(Cipher.ENCRYPT_MODE, aesKey);
            byte[] encrypted = cipher.doFinal(text.getBytes());
            return (new String(encrypted));
        } catch (InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
            e.printStackTrace();
        }
        return text;
    }

    public String deCrypt(String text) {
        try {     // decrypt the text
            cipher.init(Cipher.DECRYPT_MODE, aesKey);
            return (new String(cipher.doFinal(text.getBytes())));
        } catch (InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
        }
        return text;
    }
    
    public static void main(String []args){
        Encryptor e = new Encryptor();
    }

}
