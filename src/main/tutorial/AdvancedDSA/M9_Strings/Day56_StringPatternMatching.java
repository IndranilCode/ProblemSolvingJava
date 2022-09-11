package main.tutorial.AdvancedDSA.M9_Strings;

public class Day56_StringPatternMatching {
    public void execute() {

        //HW2 > Closest Palindrome
        System.out.println("HW2 > Closest Palindrome (madam) => " + this.closestPalindrome("madam"));
        System.out.println("    > Closest Palindrome (maddam) => " + this.closestPalindrome("maddam"));
        System.out.println("    > Closest Palindrome (medam) => " + this.closestPalindrome("meddam"));
        System.out.println("    > Closest Palindrome (medap) => " + this.closestPalindrome("meddap"));
        System.out.println("    > Closest Palindrome (medapk) => " + this.closestPalindrome("meddapk"));
    }

    /**
     * HW2 > Closest Palindrome
     * Given string A of lowercase alphabets, it is possible to make it a palindrome by changing exactly one of its character.
     * @param A
     * @return
     */
    private String closestPalindrome(String A) {
        int len = A.length();
        int changeCount = 0;
        int start = 0, end = len-1;
        while (start < end) {
            if (A.charAt(start) != A.charAt(end)) {
                changeCount++;
            }
            start = start + 1;
            end = end - 1;
        }
        //Original string is palindrome
        if (changeCount == 0) {
            if ((len % 2) == 0) {
                //Even length - can't change 1 char to make palindrome
                return "NO";
            } else {
                //Odd length - mid char can be changed
                return "YES";
            }
        } else if (changeCount == 1) {
            return "YES";
        } else {
            return "NO";
        }
    }
}
