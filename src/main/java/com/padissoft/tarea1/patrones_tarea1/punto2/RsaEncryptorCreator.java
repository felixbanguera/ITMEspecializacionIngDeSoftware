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
        // Es importante notar que como springboot tiene por defecto IoC con el contenedor de beans, 
        //   este patrón como tal NO crea nuevas intancias de los productos concretos, 
        //     sino que solo llama las instacias inyectadas por dependencia.
        return rsaEncryptor; // reusa el bean manejado por spring
    }
}
