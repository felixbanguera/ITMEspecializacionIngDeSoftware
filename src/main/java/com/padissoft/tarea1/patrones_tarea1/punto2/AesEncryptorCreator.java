package com.padissoft.tarea1.patrones_tarea1.punto2;
import org.springframework.stereotype.Component;

import com.padissoft.tarea1.patrones_tarea1.punto2.EncryptorCreator;
import com.padissoft.tarea1.patrones_tarea1.punto2.AesEncryptor;

@Component("AES")
public class AesEncryptorCreator extends EncryptorCreator {
    @Override
    public Encryptor createEncryptor() {
        return new AesEncryptor();
    }
}
