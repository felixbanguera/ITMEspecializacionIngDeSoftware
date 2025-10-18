// Main para demostrar
public class Main {
    public static void main(String[] args){
        // 1. Crear los objetos legacy
        
        User felixUser = new User("Félix", "Banguera", "felixb", "passwordExampleFelix");
        User nathyUser = new User("Nathalia", "Buitrago", "NathyB", "passwordExampleNathy");
        User carlosUser = new User("Carlos", "Valencia", "CarlosVal", "passwordExampleCarlos");
        User juanUser = new User("Juan", "Perez", "JuanP", "passwordExampleJuan");

        // 2. Crear el Adapter para ejemplo de autenticacion
        
        IAuthenticator legacyAdapter = new LegacyUserAdapter(felixUser);
        AuthClient clientLegacy = new AuthClient(legacyAdapter);

        AuthRequest credsOk = AuthRequest.withCredentials("felixb", "passwordExampleFelix");
        AuthRequest credsFail = AuthRequest.withCredentials("felixb", "NOTpasswordExampleFelix");

        clientLegacy.tryLogin(credsOk);   // esperado: true
        clientLegacy.tryLogin(credsFail); // esperado: false

        System.out.println("----");

        // 2) usar autenticación por token (otro método)
        IAuthenticator tokenAuth = new TokenAuthenticator("TOK-ABC-123");
        AuthClient clientToken = new AuthClient(tokenAuth);

        AuthRequest tokenReqOk = AuthRequest.withToken("TOK-ABC-123");
        AuthRequest tokenReqFail = AuthRequest.withToken("OTRO-TOKEN");

        clientToken.tryLogin(tokenReqOk);   // esperado: true
        clientToken.tryLogin(tokenReqFail); // esperado: false


        // ------ Ahora solucion del organigrama con Composite
        
        // 1️⃣ Crear jerarquía organizacional
        OrgComposite empresa = new OrgComposite("Pronto.inc");
        OrgComposite sedeBogota = new OrgComposite("Sede Medellín");
        OrgComposite deptTI = new OrgComposite("Departamento IT");
        OrgComposite deptRRHH = new OrgComposite("Recursos Humanos (HR)");

        // 2️⃣ Crear empleados (Leaf) a partir de LegacyUSerAdapter
        OrgComponent felixLeaf = new LegacyUserAdapter(felixUser);
        OrgComponent nathyLeaf = new LegacyUserAdapter(nathyUser);
        OrgComponent carlosLeaf = new LegacyUserAdapter(carlosUser);
        OrgComponent juanLeaf = new LegacyUserAdapter(juanUser);

        // 3️⃣ Construir jerarquía
        deptTI.add(felixLeaf);
        deptTI.add(nathyLeaf);
        deptRRHH.add(carlosLeaf);
        sedeBogota.add(juanLeaf);
        sedeBogota.add(deptTI);
        sedeBogota.add(deptRRHH);
        empresa.add(sedeBogota);

        // 4️⃣ Mostrar toda la estructura
        empresa.showInfo("");
    }
}