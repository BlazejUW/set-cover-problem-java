package cover;

import java.util.*;

public class GreedyAlgorithm extends Algorithm {
    @Override
    public List<Integer> selectCoveringSets(List<MySet> setFamily, SetToCover setToCover) {

        List<Integer> selectedSets = new LinkedList<>();
        Set<Integer> currentCover = new HashSet<>();
        boolean continueSearching = true;

        for (int i = 0; continueSearching && currentCover.size() < setToCover.getLastElement(); i++) {
            int bestSetIndex = selectBestSet(setFamily, currentCover, setToCover);
            if (bestSetIndex > -1) {
                currentCover.addAll(setFamily.get(bestSetIndex).commonValues(setToCover));
                selectedSets.add(bestSetIndex + 1);
            } else {
                continueSearching = false;
            }
        }
        if (currentCover.size() != setToCover.getLastElement()) {
            selectedSets.clear();
            selectedSets.add(0);
        }
        Collections.sort(selectedSets);
        return selectedSets;
    }

    private static int selectBestSet(List<MySet> setFamily, Set<Integer> currentCover, SetToCover setToCover) {

        int bestSetIndex = -1;
        int maxElementsAdded = 0;

        for (int i = 0; i < setFamily.size(); i++) {
            Set<Integer> newCover = new HashSet<>(currentCover);
            newCover.addAll(setFamily.get(i).commonValues(setToCover));

            int elementsAdded = newCover.size() - currentCover.size();

            if (elementsAdded > maxElementsAdded) {
                maxElementsAdded = elementsAdded;
                bestSetIndex = i;
            }
        }
        return bestSetIndex;
    }
}
