import java.util.*;
// === Composite: puede contener otros OrgComponent ===
class OrgComposite extends OrgComponent {
    private List<OrgComponent> children = new ArrayList<>();

    public OrgComposite(String name) {
        super(name);
    }

    public void add(OrgComponent component) {
        children.add(component);
    }

    public void remove(OrgComponent component) {
        children.remove(component);
    }

    @Override
    public void showInfo(String indent) {
        System.out.println(indent + "📂 " + name);
        for (OrgComponent child : children) {
            child.showInfo(indent + "   ");
        }
    }
}