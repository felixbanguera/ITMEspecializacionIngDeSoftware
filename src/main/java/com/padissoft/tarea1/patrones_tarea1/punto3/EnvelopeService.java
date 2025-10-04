package com.padissoft.tarea1.patrones_tarea1.punto3;

import com.padissoft.tarea1.patrones_tarea1.punto2.Encryptor;
import com.padissoft.tarea1.patrones_tarea1.punto2.EncryptorFactory;
import com.padissoft.tarea1.patrones_tarea1.punto3.CryptoEnvelope;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EnvelopeService {

    private final EncryptorFactory factory;
    private final Encryptor encryptor;

    // IoC/DI: Spring inyecta la factory automáticamente
    public EnvelopeService(EncryptorFactory factory) {
        this.factory = factory;
        // Para cambiar el tipo de encriptor cambiar los valores de encryption.type en resources/application.properties entre "RSA" y "AES"
        this.encryptor = factory.getEncryptor();
    }

    public CryptoEnvelope createEnvelope(String plainData, String keyId) {
        // Acá se ejecuta la cadena de creación con el patrón Builder
        return new CryptoEnvelope.CryptoEnvelopeBuilder()
                .withAlgorithm(this.encryptor.getClass().getSimpleName()) // o de properties
                .withVersion("1.0")
                .withKeyId(keyId)
                .withCreatedAt(LocalDateTime.now())
                .withEncryptedData(encryptData(plainData, keyId))
                .build();
    }

    private String encryptData(String plainData, String keyId) {
        return this.encryptor.encrypt(plainData, keyId);
    }

    public String getDecryptedData(CryptoEnvelope envelope) {
        return this.encryptor.decrypt(envelope.getEncryptedData(), envelope.getKeyId());
    }
}

