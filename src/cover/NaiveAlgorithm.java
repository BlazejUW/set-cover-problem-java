package cover;

import java.util.*;

public class NaiveAlgorithm extends Algorithm {

    @Override
    public List<Integer> selectCoveringSets(List<MySet> setFamily, SetToCover setToCover) {

        List<Integer> selectedSets = new LinkedList<>();
        Set<Integer> currentCover = new HashSet<>();

        for (int i = 0; i < setFamily.size(); i++) {
            Set<Integer> currentSet = setFamily.get(i).commonValues(setToCover);
            if (!currentCover.containsAll(currentSet)) {
                currentCover.addAll(currentSet);
                selectedSets.add(i + 1);
            }
        }
        if (!(currentCover.size() == setToCover.getLastElement())) {
            selectedSets.clear();
            selectedSets.add(0);
        }
        return selectedSets;
    }
}
