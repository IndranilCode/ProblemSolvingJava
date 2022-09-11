package main.tutorial;

import java.util.ArrayList;
import java.util.HashMap;

public class I1_Cisco {
    public void execute() {
        //        String inputWord = "he 55 is a good programmer,    he won 865 competitions, but sometimes he dont. What do you think? All test-cases should pass. Done-done?";
        String inputWord = "878  dwa";
        System.out.println(this.howManyWords(inputWord));

        perfectSubstring("1102021222", 2);
    }


    private int howManyWords(String sentence) {
        sentence = sentence + " ";
        int n = sentence.length();
        int wordCount = 0;
        int prevSpace = -1;
        boolean isValidWord = true;
        for (int i = 0; i < n; i++) {
            char currentChar = sentence.charAt(i);
            if (currentChar == ' ') {
                if (isValidWord) {
                    if (i - prevSpace > 1) {
                        wordCount = wordCount + 1;
                    }

                }
                prevSpace = i;
                isValidWord = true;
            }
            else {
                if (!((currentChar >= 'a' && currentChar <= 'z') || (currentChar >= 'A' && currentChar <= 'Z') || (currentChar == '.' || currentChar == ',' || currentChar == '?' || currentChar == '!' || currentChar == '-'))) {
                    isValidWord = false;
                }
            }
        }
        return wordCount;
    }

    private int perfectSubstring(String s, int k) {
        int resultCount = 0;
        int n = s.length();
        if (k <= n) {
            ArrayList<Integer> substringLengths = new ArrayList<>();
            int i = 1;
            while (i * k <= n) {
                substringLengths.add((i * k));
                i++;
            }

            for (int q = 0; q < substringLengths.size(); q++) {
                //For each substring length
                int currentSubstringLength = substringLengths.get(q);


                for (int x = 0; x <= (n-currentSubstringLength); x++) {
                    for (int y = (currentSubstringLength-1);  y < n; y++) {
                        HashMap<Character, Integer> numberFreq = new HashMap<>();
                        for (int z = x; z <= y; z++) {
                            Character currentChar = s.charAt(z);
                            numberFreq.put(currentChar, (numberFreq.containsKey(currentChar)) ? (numberFreq.get(currentChar) + 1) : 1);
                        }
                        boolean isCounted = true;
                        for (int freq : numberFreq.values()) {
                            if ((freq % k) != 0) {
                                isCounted = false;
                            }
                        }
                        if (isCounted) {
                            resultCount++;
                        }
                        x++;
                    }
                }
            }
        }
        return resultCount;
    }
}
