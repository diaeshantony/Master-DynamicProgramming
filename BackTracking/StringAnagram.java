package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class StringAnagram {

    public static void main(String[] args) {
        System.out.println("The output is " + findPermute());
    }

    // Approach 1, using swap method
    public static List<String> findPermutations() {
        String str = "abc";
        List<String> outList = new ArrayList<>();
        generateAnagrams(str.toCharArray(), 0, outList);
        return outList;
    }

    public static void generateAnagrams(char[] chars, int start, List<String> outList) {
        if (start == chars.length - 1) {
            outList.add(String.valueOf(chars));
        }

        for (int i = start; i < chars.length; i++) {
            swap(chars, start, i);
            generateAnagrams(chars, start + 1, outList);
            swap(chars, start, i);
        }
    }



    public static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    // Approach 2 using boolean[] used
    public static List<String> findPermute() {
        String str = "abc";
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);
        List<String> outList = new ArrayList<>();
        generateAnagrams(charArray, new char[str.length()], new boolean[str.length()], outList, 0);
        return outList;
    }

    public static void generateAnagrams(char[] input,
                                        char[] anagram,
                                        boolean[] visited,
                                        List<String> outList,
                                        int index) {
        if (index == input.length) {
            outList.add(String.valueOf(anagram));
        }

        for (int i = 0; i < input.length; i++) {
            if (!visited[i] && !(i > 0 && input[i] == input[i - 1] && visited[i - 1])) {
                visited[i] = true;
                anagram[index] = input[i];
                generateAnagrams(input, anagram, visited, outList, index + 1);
                visited[i] = false;
            }
        }
    }
}
