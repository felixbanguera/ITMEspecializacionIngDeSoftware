// Petición de autenticación (objeto contenedor para poder soportar distintos métodos)
public class AuthRequest {
    public String username;
    public String password;
    public String token;

    public AuthRequest() {}
    public static AuthRequest withCredentials(String u, String p){
        AuthRequest r = new AuthRequest();
        r.username = u; r.password = p; return r;
    }
    public static AuthRequest withToken(String t){
        AuthRequest r = new AuthRequest();
        r.token = t; return r;
    }
}