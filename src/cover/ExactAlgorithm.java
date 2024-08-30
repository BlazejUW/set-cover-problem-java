package cover;

import java.math.BigInteger;
import java.util.*;

public class ExactAlgorithm extends Algorithm {
    @Override
    public List<Integer> selectCoveringSets(List<MySet> setFamily, SetToCover setToCover) {

        int numberOfSets = setFamily.size();
        BigInteger maxPlusOne = BigInteger.ONE.shiftLeft(numberOfSets);

        List<Integer> setsList = new ArrayList<>(setFamily.size());
        for (int i = 0; i < setFamily.size(); i++) {
            setsList.add(i + 1);
        }

        int minimumNumberOfSubsets = 0;
        List<Integer> selectedSets = new LinkedList<>();

        for (BigInteger i = BigInteger.ONE; i.compareTo(maxPlusOne) < 0; i = i.add(BigInteger.ONE)) {

            List<Integer> newSubset = convertBigIntegerToSubset(setsList, i);

            if (selectedSets.isEmpty() || newSubset.size() < minimumNumberOfSubsets) {
                Set<Integer> currentCover = new HashSet<>();

                for (Integer integer : newSubset) {
                    int index = integer - 1;
                    currentCover.addAll(setFamily.get(index).commonValues(setToCover));
                }
                if (currentCover.size() == setToCover.getLastElement()) {
                    minimumNumberOfSubsets = newSubset.size();
                    selectedSets = newSubset;
                }
            }
        }
        if (selectedSets.isEmpty()) {
            selectedSets.add(0);
        }
        return selectedSets;
    }

    private static List<Integer> convertBigIntegerToSubset(List<Integer> set, BigInteger subset) {
        List<Integer> newSubset = new LinkedList<>();
        int i = 0;
        for (Integer element : set) {
            if (subset.testBit(i)) {
                newSubset.add(element);
            }
            i++;
        }
        return newSubset;
    }
}
