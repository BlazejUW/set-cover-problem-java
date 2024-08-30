package cover;

import java.util.List;

public class Query {

    private SetToCover setToCover;
    private int algorithmNumber;

    public Query(SetToCover setToCover, int algorithmNumber) {
        this.setToCover = setToCover;
        this.algorithmNumber = algorithmNumber;
    }

    public List<Integer> findSetCover(List<MySet> setFamily) {
        if (algorithmNumber == 1) {
            return new ExactAlgorithm().selectCoveringSets(setFamily, setToCover);
        } else if (algorithmNumber == 2) {
            return new GreedyAlgorithm().selectCoveringSets(setFamily, setToCover);
        } else {
            return new NaiveAlgorithm().selectCoveringSets(setFamily, setToCover);
        }
    }
}
