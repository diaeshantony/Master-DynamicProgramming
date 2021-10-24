package BackTracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class WordBreak {
    public static void main(String[] args) {
        String str = "catsanddogs";
        HashSet<String> dict = new HashSet<>();
        dict.add("cat");
        dict.add("cats");
        dict.add("and");
        dict.add("sand");
        dict.add("dog");
        List<List<String>> outList = new ArrayList<>();
        wordBreak(str, dict, outList, new ArrayList<String>());
        System.out.println("The output list is :" + outList);
    }
    public static void wordBreak(String input,
                                 HashSet<String> dict,
                                 List<List<String>> outList,
                                 List<String> partialString) {

        if (input.length() == 0) {
            outList.add(new ArrayList<String>(partialString));
        }

        for (int i = 0; i < input.length(); i++) {
            String word = input.substring(0, i + 1);
            if (dict.contains(word)) {
                partialString.add(word);
                wordBreak(input.substring(i + 1), dict, outList, partialString);
                partialString.remove(partialString.size() - 1);
            }
        }
    }
}
