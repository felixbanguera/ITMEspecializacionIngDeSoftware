package com.padissoft.tarea1.patrones_tarea1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;

import com.padissoft.tarea1.patrones_tarea1.punto2.EncryptionService;

@SpringBootApplication
public class PatronesTarea1Application implements CommandLineRunner {

    private final EncryptionService service;

    public PatronesTarea1Application(EncryptionService service) {
        this.service = service;
    }

    public static void main(String[] args) {
        SpringApplication.run(PatronesTarea1Application.class, args);
    }

    @Override
    public void run(String... args) {
        String data = "4111111111111111";
        String encrypted = service.storeData(data);
        System.out.println("Dato encriptado: " + encrypted);
        System.out.println("Dato desencriptado: " + service.readData(encrypted));
    }
}
