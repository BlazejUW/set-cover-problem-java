package cover;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Element extends Component {

    private int value;

    public Element(int value) {
        this.value = value;
    }

    @Override
    Set<Integer> commonValues(SetToCover setToCover) {
        Set<Integer> coverage = new HashSet<>();
        if (value <= setToCover.getLastElement() && value > 0) {
            coverage.add(value);
        }
        return coverage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Element element = (Element) o;
        return value == element.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
