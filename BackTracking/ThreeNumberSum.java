package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ThreeNumberSum {
    public static void main(String[] args) {
        int[] input = {1, 3, 5, 4 , 2};
        // Target sum = 6
        // output [[1, 2, 3], [1, 5], [2, 4], [3, 3], [4, 2]]
        Arrays.sort(input);
        List<List<Integer>> outList = new ArrayList<>();
        List<Integer> partialSum = new ArrayList<>();
        combinationSum(input, 6, 0, 0, outList, partialSum);
        System.out.println(outList);

    }

    public static void combinationSum(int[] array,
                                      int target,
                                      int sum,
                                      int start,
                                      List<List<Integer>> outList,
                                      List<Integer> partialSum) {
        if (target == sum) {
            outList.add(new ArrayList<>(partialSum));
        }

        for (int i = start; i < array.length; i++) {
            int c = array[i];

            if (c + sum > target && i > start && array[i - 1] == array[i]) {
                continue;
            }

            partialSum.add(c);
            combinationSum(array, target, sum + c, start + 1, outList, partialSum);
            partialSum.remove(partialSum.size() - 1);
        }
    }
}
