import java.util.HashSet;

public class RemoveDuplicates {
    public static void main(String[] args) {
        // Input string – you can change this to test other strings
        String input = "programming";

        // HashSet to keep track of characters we've already seen
        HashSet<Character> seen = new HashSet<>();

        // This will hold the result without duplicates
        String result = "";

        // Loop through each character of the input string
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            // If the character is not already in the set, it's unique so far
            if (!seen.contains(ch)) {
                seen.add(ch);        // mark it as seen
                result += ch;        // add it to the result (basic string concatenation)
            }
        }

        // Print the final string without duplicate characters
        System.out.println("Original: " + input);
        System.out.println("After removing duplicates: " + result);
    }
}
