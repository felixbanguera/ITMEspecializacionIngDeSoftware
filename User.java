// Clase legado (NO MODIFICAR)
public final class User {
    private String username;
    private String password;

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }

    // Método legado exigido por tu enunciado
    public boolean checkUserNameandPassword(String user, String pass) {
        // Simulación: compara cadenas (en la realidad puede ser consulta a BD)
        return this.username.equals(user) && this.password.equals(pass);
    }

    // getters legacy (si existen)
    public String getUsername() { return username; }
    public String getPassword() { return password; }
}