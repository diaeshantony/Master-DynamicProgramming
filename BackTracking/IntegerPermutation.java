package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;

public class IntegerPermutation {
    public static void main(String[] args) {
        int[] input = {1, 2, 3};
        boolean[] out = new boolean[input.length];
        ArrayList<Integer> output = new ArrayList<>();
        permutation(input, output, out);
    }

    public static void permutation(int[] input, ArrayList<Integer> partial, boolean[] used) {
        if (partial.size() == input.length) {
            System.out.println(Arrays.toString(partial.toArray()));
        }

        for (int i = 0; i < input.length; i++) {
            if (!used[i]) {
                used[i] = true;
                partial.add(input[i]);
                permutation(input, partial, used);
                used[i] = false;
                partial.remove(partial.size() - 1);
            }
        }
    }
}
