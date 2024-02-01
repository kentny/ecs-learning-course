package com.example.encryptor.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;


@RestController
@RequestMapping("/api/encryptor")
public class EncryptorController {
    @GetMapping
    String get() throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        SecretKey key = KeyGenerator.getInstance("AES").generateKey();
        Cipher cipher = Cipher.getInstance("AES");

        for (int i=0; i<100000; i++) {
            byte[] data = new byte[256];
            cipher.init(Cipher.ENCRYPT_MODE, key);
            cipher.doFinal(data);
        }

        return "Finish!";
    }
}
