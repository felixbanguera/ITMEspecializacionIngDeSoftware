package com.padissoft.tarea1.patrones_tarea1.punto3;

import java.time.LocalDateTime;

public final class CryptoEnvelope {

    private final String algorithm;
    private final String version;
    private final String keyId;
    private final LocalDateTime createdAt;
    private final String encryptedData;

    // Constructor privado → solo accesible desde el Builder
    private CryptoEnvelope(CryptoEnvelopeBuilder builder) {
        this.algorithm = builder.algorithm;
        this.version = builder.version;
        this.keyId = builder.keyId;
        this.createdAt = builder.createdAt;
        this.encryptedData = builder.encryptedData;
    }

    // Getters (sin setters → objeto inmutable)
    public String getAlgorithm() { return algorithm; }
    public String getVersion() { return version; }
    public String getKeyId() { return keyId; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public String getEncryptedData() { return encryptedData; }

    // Builder interno: recomendado segun buenas prácticas de Java 
    public static class CryptoEnvelopeBuilder {
        private String algorithm;
        private String version;
        private String keyId;
        private LocalDateTime createdAt;
        private String encryptedData;

        public CryptoEnvelopeBuilder withAlgorithm(String algorithm) {
            this.algorithm = algorithm;
            return this;
        }

        public CryptoEnvelopeBuilder withVersion(String version) {
            this.version = version;
            return this;
        }

        public CryptoEnvelopeBuilder withKeyId(String keyId) {
            this.keyId = keyId;
            return this;
        }

        public CryptoEnvelopeBuilder withCreatedAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public CryptoEnvelopeBuilder withEncryptedData(String encryptedData) {
            this.encryptedData = encryptedData;
            return this;
        }

        // Validación de campos obligatorios
        public CryptoEnvelope build() {
            if (algorithm == null || keyId == null || encryptedData == null) {
                throw new IllegalStateException("algorithm, keyId y encryptedData son obligatorios");
            }
            if (createdAt == null) {
                createdAt = LocalDateTime.now();
            }
            if (version == null) {
                version = "1.0";
            }
            return new CryptoEnvelope(this);
        }
    }
}

