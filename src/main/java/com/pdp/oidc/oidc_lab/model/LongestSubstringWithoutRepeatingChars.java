package com.pdp.oidc.oidc_lab.model;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LongestSubstringWithoutRepeatingChars {
    public static List<Character> longestSubstringWithoutRepeatingChars(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        
        // Array to hold mutable state: [left, maxLength, startOfLongest]
        int[] state = {0, 0, 0};

        IntStream.range(0, s.length()).forEach(right -> {
            char currentChar = s.charAt(right);

            // Update the left pointer if we've seen this character before
            if (map.containsKey(currentChar)) {
                state[0] = Math.max(state[0], map.get(currentChar) + 1);
            }

            // Update character's latest position
            map.put(currentChar, right);

            // Check if we have a new maximum length, and update state accordingly
            if (right - state[0] + 1 > state[1]) {
                state[1] = right - state[0] + 1;
                state[2] = state[0]; // Update start index of the longest substring
            }
        });

        // Collect the longest substring as a list of characters
        return IntStream.range(state[2], state[2] + state[1])
                .mapToObj(s::charAt)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        String input = "my name is subhash";
        List<Character> result = longestSubstringWithoutRepeatingChars(input);
        System.out.println("The longest substring without repeating characters is: " + result);
    }
}
