package BackTracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SelectKElements {
    public static void main(String[] args) {
        int[] input = {3, 2, 5, 8};
        HashSet<Integer> set = new HashSet<>();
        HashSet<HashSet<Integer>> outSet = new HashSet<>();
        combinations(input, set, outSet, 0, 3);
        System.out.println(outSet);
    }

    public static void combinations(int[] input,
                                    HashSet<Integer> set,
                                    HashSet<HashSet<Integer>> outSet,
                                    int start,
                                    int k) {
        if (set.size() == k) {
            outSet.add(new HashSet<>(set));
        }

        if (start == input.length) {
            return;
        }

        for (int i = start; i < input.length; i++) {
            set.add(input[i]);
            combinations(input, set, outSet, start + 1, k);
            set.remove(input[i]);
        }
    }
}
