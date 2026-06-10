import java.util.HashMap;

public class AnagramCheck {
    public static void main(String[] args) {
        // Test strings – change these to try other words
        String str1 = "listen";
        String str2 = "silent";

        boolean result = areAnagrams(str1, str2);
        System.out.println("\"" + str1 + "\" and \"" + str2 + "\" are anagrams? " + result);
    }

    public static boolean areAnagrams(String s1, String s2) {
        // Step 1: If lengths differ, they cannot be anagrams.
        if (s1.length() != s2.length()) {
            return false;
        }

        // Step 2: Create a HashMap to count character frequencies.
        HashMap<Character, Integer> charCount = new HashMap<>();

        // Step 3: Count every character in the first string.
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);

            if (charCount.containsKey(c)) {
                // Character already seen: increase its count by 1.
                int currentCount = charCount.get(c);
                charCount.put(c, currentCount + 1);
            } else {
                // First time seeing this character: start count at 1.
                charCount.put(c, 1);
            }
        }

        // Step 4: Use the second string to decrease the counts.
        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);

            // If the character is missing or its count is already 0, not anagrams.
            if (!charCount.containsKey(c) || charCount.get(c) == 0) {
                return false;
            }

            // Decrease the count by 1 (we "used" one occurrence).
            int currentCount = charCount.get(c);
            charCount.put(c, currentCount - 1);
        }

        // Step 5: If we finish without returning false, all counts matched exactly.
        return true;
    }
}
