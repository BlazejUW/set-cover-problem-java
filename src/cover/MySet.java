package cover;

import java.util.HashSet;
import java.util.Set;

public class MySet {
    private Set<Component> components;

    public MySet(Set<Component> components) {
        this.components = components;
    }

    public Set<Integer> commonValues(SetToCover setToCover) {
        Set<Integer> coveredElements = new HashSet<>();

        for (Component component : components) {
            Set<Integer> coveredElementsByComponent = component.commonValues(setToCover);
            coveredElements.addAll(coveredElementsByComponent);
        }
        return coveredElements;
    }
}
