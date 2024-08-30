package cover;

import java.util.HashSet;
import java.util.Set;

public class Infinite extends Component {
    private int start;
    private int step;

    public Infinite(int start, int step) {
        this.start = start;
        this.step = step;
    }

    @Override
    Set<Integer> commonValues(SetToCover setToCover) {
        Set<Integer> coverage = new HashSet<>();

        for (int i = start; i <= setToCover.getLastElement(); i += step) {
            coverage.add(i);
        }
        return coverage;
    }
}
