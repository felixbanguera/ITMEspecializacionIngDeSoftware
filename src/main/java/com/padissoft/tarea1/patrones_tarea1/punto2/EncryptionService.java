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
        // Para cambiar el tipo de encriptor cambiar los valores de encryption.type en resources/application.properties entre "RSA" y "AES"
        Encryptor encryptor = factory.getEncryptor();
        return encryptor.encrypt(data);
    }

    public String decryptData(String encrypted) {
        // Para cambiar el tipo de encriptor cambiar los valores de encryption.type en resources/application.properties entre "RSA" y "AES"
        Encryptor encryptor = factory.getEncryptor();
        return encryptor.decrypt(encrypted);
    }
}
