package com.padissoft.tarea1.patrones_tarea1.punto2;
import org.springframework.stereotype.Component;

import com.padissoft.tarea1.patrones_tarea1.punto2.Encryptor;

@Component("RSAencryptor") //@Component es una anotacion que marca esta clase como un Bean
public class RsaEncryptor implements Encryptor {
    @Override
    public String encrypt(String data, String keyId) {
        return "[RSA]" + "[" + keyId + "]" + data;
    }
    @Override
    public String decrypt(String data, String keyId) {
        String keyIdString = "[" + keyId + "]";
        String tempData = data.replace(keyIdString, "");
        return tempData.replace("[RSA]", "");
    }
}