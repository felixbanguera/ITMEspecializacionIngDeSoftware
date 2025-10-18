// Main para demostrar
public class Main {
    public static void main(String[] args){
        // 1) usar el legacy a través del adapter
        
        User legacy = new User("felix", "secreto");
        
        IAuthenticator legacyAdapter = new LegacyUserAdapter(legacy);
        AuthClient clientLegacy = new AuthClient(legacyAdapter);

        AuthRequest credsOk = AuthRequest.withCredentials("felix", "secreto");
        AuthRequest credsFail = AuthRequest.withCredentials("felix", "mal");

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

        // 2️⃣ Crear empleados (Leaf)
        UserLeaf emp1 = new UserLeaf("Roberto - Desarrollador");
        UserLeaf emp2 = new UserLeaf("Danilo - SysAdmin");
        UserLeaf emp3 = new UserLeaf("Carla - HR");

        // 3️⃣ Construir jerarquía
        deptTI.add(emp1);
        deptTI.add(emp2);
        deptRRHH.add(emp3);
        sedeBogota.add(deptTI);
        sedeBogota.add(deptRRHH);
        empresa.add(sedeBogota);

        // 4️⃣ Mostrar toda la estructura
        empresa.showInfo("");
    }
}