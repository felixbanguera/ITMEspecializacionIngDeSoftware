// Cliente que consume IAuthenticator (ej. el nuevo mecanismo de auth)
public class AuthClient {
    private final IAuthenticator authenticator;

    public AuthClient(IAuthenticator authenticator){
        this.authenticator = authenticator;
    }

    public void tryLogin(AuthRequest req){
        boolean result = authenticator.authenticate(req);
        System.out.println("[AuthClient] Resultado: " + result);
    }
}
