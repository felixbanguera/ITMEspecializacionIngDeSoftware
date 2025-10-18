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
