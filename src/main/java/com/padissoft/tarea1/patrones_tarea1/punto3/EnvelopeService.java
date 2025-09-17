package com.padissoft.tarea1.patrones_tarea1.punto3;

import com.padissoft.tarea1.patrones_tarea1.punto2.Encryptor;
import com.padissoft.tarea1.patrones_tarea1.punto2.EncryptorFactory;
import com.padissoft.tarea1.patrones_tarea1.punto3.CryptoEnvelope;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EnvelopeService {

    private final EncryptorFactory factory;

    // IoC/DI: Spring inyecta la factory automáticamente
    public EnvelopeService(EncryptorFactory factory) {
        this.factory = factory;
    }

    public CryptoEnvelope createEnvelope(String plainData, String keyId) {
        Encryptor encryptor = factory.getEncryptor();
        String encrypted = encryptor.encrypt(plainData, keyId);

        return new CryptoEnvelope.CryptoEnvelopeBuilder()
                .withAlgorithm(encryptor.getClass().getSimpleName()) // o de properties
                .withVersion("1.0")
                .withKeyId(keyId)
                .withCreatedAt(LocalDateTime.now())
                .withEncryptedData(encrypted)
                .build();
    }

    public String getDecryptedData(CryptoEnvelope envelope) {
        Encryptor encryptor = factory.getEncryptor();
        return encryptor.decrypt(envelope.getEncryptedData(), envelope.getKeyId());
    }
}

