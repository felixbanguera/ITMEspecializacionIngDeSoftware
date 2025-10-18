// Clase legado (NO MODIFICAR)
public final class User {
    private String firstname;
    private String lastname;
    private String username;
    private String password;

    public User(String firstname, String lastname, String username, String password){
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
    }

    // Método legado exigido por el enunciado
    public boolean checkUserNameandPassword(String user, String pass) {
        // Simulación: compara cadenas (en la realidad puede ser consulta a BD)
        return this.username.equals(user) && this.password.equals(pass);
    }

    // getters legacy
    public String getFirstname() { return firstname; }
    public String getLastname() { return lastname; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }

    // setters legacy
    public void setFirstname(String attr) { this.firstname = attr; }
    public void setLastname(String attr) { this.lastname = attr; }
    public void setUsername(String attr) { this.username = attr; }
    public void setPassword(String attr) { this.password = attr; }
}