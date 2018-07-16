//https://www.interviewcake.com/question/java/permutation-palindrome?course=fc1&section=hashing-and-hash-tables

import java.util.Set;
import java.util.HashSet;

public static boolean hasPalindromePermutation(String theString) {

    // track characters we've seen an odd number of times
    Set<Character> unpairedCharacters = new HashSet<>();

    for (char c : theString.toCharArray()) {
        if (unpairedCharacters.contains(c)) {
            unpairedCharacters.remove(c);
        } else {
            unpairedCharacters.add(c);
        }
    }

    // the string has a palindrome permutation if it
    // has one or zero characters without a pair
    return unpairedCharacters.size() <= 1;
}