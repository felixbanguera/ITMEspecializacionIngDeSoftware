// === Componente base ===
abstract class OrgComponent {
    protected String name;

    public OrgComponent(String name) {
        this.name = name;
    }

    public String getName() { return name; }

    // Método común para mostrar la estructura
    public abstract void showInfo(String indent);
}