package com.padissoft.tarea1.patrones_tarea1.punto2;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;
import java.util.Map;

import com.padissoft.tarea1.patrones_tarea1.punto2.EncryptorCreator;

@Component
public class EncryptorFactory {

    private final Map<String, EncryptorCreator> creators;
    private final String encryptionType;

    public EncryptorFactory(Map<String, EncryptorCreator> creators,
                            @Value("${encryption.type}") String encryptionType) {
        this.creators = creators;
        this.encryptionType = encryptionType.toUpperCase();
    }

    public Encryptor getEncryptor() {
        EncryptorCreator creator = creators.get(encryptionType);
        if (creator == null) {
            throw new IllegalArgumentException("No se encontró un cifrador para: " + encryptionType);
        }
        return creator.createEncryptor();
    }
}

