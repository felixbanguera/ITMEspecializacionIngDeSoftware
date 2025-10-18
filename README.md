# Explicación de cómo se abordaría este problema, justificando la elección del diseño:

Compatibilidad con legado (Adapter): No se toca la clase User. El LegacyUserAdapter traduce la nueva petición al método checkUserNameandPassword() del legado. El sistema viejo sigue intacto.

Abierto a extensiones (OCP): si mañana se necesita otro método (LDAP, OAuth, SAML), se crea otra clase que implemente IAuthenticator sin cambiar código existente.

Sustitución Liskov (LSP): cualquier IAuthenticator puede ser usada por el cliente sin conocer su implementación.

DIP: el cliente depende de la abstracción IAuthenticator, no de implementaciones concretas.

SRP: cada clase tiene una sola responsabilidad (legacy: datos/validación legado; adapter: adaptación; tokenAuth: validar token; cliente: usar autenticador).

### Next steps

Factory para crear el IAuthenticator adecuado según configuración (por ejemplo, "legacy", "token", "oauth"). Facilita intercambio en runtime.