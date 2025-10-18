// Otro autenticador (por ejemplo, token-based). También implementa IAuthenticator
public class TokenAuthenticator implements IAuthenticator {
    // En real, verificarías token contra un servidor/DB. Aquí simulamos.
    private final String validToken;

    public TokenAuthenticator(String validToken) {
        this.validToken = validToken;
    }

    @Override
    public boolean authenticate(AuthRequest req) {
        if (req.token == null) {
            System.out.println("[TokenAuthenticator] No se proporcionó token.");
            return false;
        }
        boolean ok = validToken.equals(req.token);
        System.out.println("[TokenAuthenticator] Autenticación por token: " + ok);
        return ok;
    }
}
