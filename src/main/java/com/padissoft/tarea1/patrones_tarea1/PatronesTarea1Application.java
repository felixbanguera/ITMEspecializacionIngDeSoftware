package com.padissoft.tarea1.patrones_tarea1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;

import com.padissoft.tarea1.patrones_tarea1.punto3.EnvelopeService;
import com.padissoft.tarea1.patrones_tarea1.punto3.CryptoEnvelope;

@SpringBootApplication
public class PatronesTarea1Application implements CommandLineRunner {

    private final EnvelopeService envelopeService;

    public PatronesTarea1Application(EnvelopeService envelopeService) {
        this.envelopeService = envelopeService;
    }

    public static void main(String[] args) {
        SpringApplication.run(PatronesTarea1Application.class, args);
    }

    @Override
    public void run(String... args) {
        CryptoEnvelope envelope = envelopeService.createEnvelope("4111111111111111", "key-123");
        System.out.println("Envelope creado:");
        System.out.println("Algoritmo: " + envelope.getAlgorithm());
        System.out.println("Versión: " + envelope.getVersion());
        System.out.println("KeyId: " + envelope.getKeyId());
        System.out.println("Fecha: " + envelope.getCreatedAt());
        System.out.println("Dato cifrado: " + envelope.getEncryptedData());

        System.out.println("Dato des - cifrado: " + envelopeService.getDecryptedData(envelope));
    }
}
