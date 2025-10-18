// Interfaz común para autenticadores (contrato que usa el sistema nuevo)
public interface IAuthenticator {
    boolean authenticate(AuthRequest req);
}
