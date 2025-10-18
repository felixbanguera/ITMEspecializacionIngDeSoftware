// ESTA CLASE NO SE ESTA USANDO porque se separarían en 2 las soluciones.
// Entonces se usa el LeagcyUserAdapter tambien como Leaf del composite.
// === Leaf: usuario final (empleado) ===
class UserLeaf extends OrgComponent {
    public UserLeaf(String name) {
        super(name);
    }

    @Override
    public void showInfo(String indent) {
        System.out.println(indent + "👤 " + name);
    }
}
