package com.padissoft.tarea1.patrones_tarea1.punto2;
import org.springframework.stereotype.Component;

import com.padissoft.tarea1.patrones_tarea1.punto2.Encryptor;

@Component("AESencryptor") //@Component es una anotacion que marca esta clase como un Bean
public class AesEncryptor implements Encryptor {
    @Override
    public String encrypt(String data) {
        return "[AES]" + data;
    }
    @Override
    public String decrypt(String data) {
        return data.replace("[AES]", "");
    }
}