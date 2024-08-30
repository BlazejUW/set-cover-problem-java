package cover;

import java.util.HashSet;
import java.util.Set;

public class Finite extends Component {
    private int start;
    private int step;
    private int end;

    public Finite(int start, int step, int end) {
        this.start = start;
        this.step = step;
        this.end = end;
    }

    @Override
    Set<Integer> commonValues(SetToCover setToCover) {
        Set<Integer> coverage = new HashSet<>();

        for (int i = start; i <= end && i <= setToCover.getLastElement(); i += step) {
            coverage.add(i);
        }
        return coverage;
    }
}
