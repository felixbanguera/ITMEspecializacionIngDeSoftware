// ADAPTER: adapta la clase legado User al contrato IAuthenticator
//LEAF: Queda siendo parte del composite como una hoja (Leaf) al extender el OrgComponent
public class LegacyUserAdapter extends OrgComponent implements IAuthenticator {
    private final User legacyUser;

    public LegacyUserAdapter(User legacyUser) {
        this.legacyUser = legacyUser;
        super(legacyUser.getUsername());
    }

    private String nameToDisplay(){
        return legacyUser.getFirstname() +" "+ legacyUser.getLastname() +" ("+ legacyUser.getUsername()+")";
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

    @Override
    public void showInfo(String indent) {
        System.out.println(indent + "👤 " + this.nameToDisplay());
    }
}
