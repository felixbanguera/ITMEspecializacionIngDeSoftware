package com.padissoft.tarea1.patrones_tarea1.punto2;
import org.springframework.stereotype.Service;

import com.padissoft.tarea1.patrones_tarea1.punto2.EncryptorFactory;

@Service
public class EncryptionService {
    private final EncryptorFactory factory;

    public EncryptionService(EncryptorFactory factory) {
        this.factory = factory;
    }

    public String encryptData(String data) {
        Encryptor encryptor = factory.getEncryptor();
        return encryptor.encrypt(data);
    }

    public String decryptData(String encrypted) {
        Encryptor encryptor = factory.getEncryptor();
        return encryptor.decrypt(encrypted);
    }
}
