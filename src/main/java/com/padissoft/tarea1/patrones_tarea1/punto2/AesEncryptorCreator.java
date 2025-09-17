package com.padissoft.tarea1.patrones_tarea1.punto2;
import org.springframework.stereotype.Component;

import com.padissoft.tarea1.patrones_tarea1.punto2.EncryptorCreator;
import com.padissoft.tarea1.patrones_tarea1.punto2.AesEncryptor;

@Component("AES")
public class AesEncryptorCreator extends EncryptorCreator {
    private final AesEncryptor aesEncryptor;

    public AesEncryptorCreator(AesEncryptor aesEncryptor) {
        this.aesEncryptor = aesEncryptor;
    }

    @Override
    public Encryptor createEncryptor() {
        return aesEncryptor; // reuse Spring-managed bean
    }
}
