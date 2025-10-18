// ADAPTER: adapta la clase legado User al contrato IAuthenticator
public class LegacyUserAdapter implements IAuthenticator {
    private final User legacyUser;

    public LegacyUserAdapter(User legacyUser) {
        this.legacyUser = legacyUser;
    }

    @Override
    public boolean authenticate(AuthRequest req) {
        // Traduce la petición al método legado
        if (req.username == null || req.password == null) {
            System.out.println("[LegacyUserAdapter] Faltan username/password en la petición.");
            return false;
        }
        boolean ok = legacyUser.checkUserNameandPassword(req.username, req.password);
        System.out.println("[LegacyUserAdapter] Autenticación legado para '" + req.username + "': " + ok);
        return ok;
    }
}
