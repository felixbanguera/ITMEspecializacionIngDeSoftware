package com.padissoft.tarea1.patrones_tarea1.punto2;
import org.springframework.stereotype.Component;

import com.padissoft.tarea1.patrones_tarea1.punto2.EncryptorCreator;
import com.padissoft.tarea1.patrones_tarea1.punto2.RsaEncryptor;

@Component("RSA")
public class RsaEncryptorCreator extends EncryptorCreator {
    private final RsaEncryptor rsaEncryptor;

    public RsaEncryptorCreator(RsaEncryptor rsaEncryptor) {
        this.rsaEncryptor = rsaEncryptor;
    }

    @Override
    public Encryptor createEncryptor() {
        return rsaEncryptor;
    }
}
