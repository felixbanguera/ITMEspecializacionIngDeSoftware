# Explicación de cómo se abordaría este problema, justificando la elección del diseño:

Compatibilidad con legado (Adapter): No se toca la clase User. El LegacyUserAdapter traduce la nueva petición al método checkUserNameandPassword() del legado. El sistema viejo sigue intacto.

Abierto a extensiones (OCP): si mañana se necesita otro método (LDAP, OAuth, SAML), se crea otra clase que implemente IAuthenticator sin cambiar código existente.

Sustitución Liskov (LSP): cualquier IAuthenticator puede ser usada por el cliente sin conocer su implementación.

DIP: el cliente depende de la abstracción IAuthenticator, no de implementaciones concretas.

SRP: cada clase tiene una sola responsabilidad (legacy: datos/validación legado; adapter: adaptación; tokenAuth: validar token; cliente: usar autenticador).

### Next steps

Factory para crear el IAuthenticator adecuado según configuración (por ejemplo, "legacy", "token", "oauth"). Facilita intercambio en runtime.

### Como correrlo:

Compilar: `javac *.java`

Correr el maim: `java Main`

## Ventajas del patrón Composite en la solución

| Requisito                                          | Cómo lo cumple Composite                                                   |
| -------------------------------------------------- | -------------------------------------------------------------------------- |
| **Gestión jerárquica de la organización**          | Permite modelar sedes, departamentos y empleados bajo una misma interfaz.  |
| **Operaciones sencillas sobre toda la estructura** | Llamar a `showInfo()` sobre la empresa recorre todo automáticamente.       |
| **Extensibilidad (OCP)**                           | Puedes añadir nuevos tipos de nodos (por ejemplo, “Proyecto”, “Equipo”) sin modificar código existente. |


## Resumen

| Elemento                         | Patrón aplicado     | Propósito                                                     |
| -------------------------------- | ------------------- | ------------------------------------------------------------- |
| **UserAdapter**                  | Adapter             | Conectar el nuevo sistema con el legado sin modificarlo.      |
| **OrgComposite** / **UserLeaf**  | Composite           | Representar la jerarquía (empresa → dependencias → usuarios). |
| **AuthRequest / IAuthenticator** | Interface abstraída | Cumplir con DIP y OCP.                                        |
