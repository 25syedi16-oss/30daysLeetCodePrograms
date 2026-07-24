import java.util.*;

class Solution {
    public String[] findWords(String[] words) {
        // Map the 26 English letters (a-z) to their keyboard row (1, 2, or 3)
        // a=2, b=3, c=3, d=2, e=1, f=2, etc.
        int[] rowMap = {2,3,3,2,1,2,2,2,1,2,2,2,3,3,1,1,1,1,2,1,1,3,1,3,1,3};
        
        List<String> result = new ArrayList<>();
        
        for (String word : words) {
            // Only add the word if our helper method confirms it's valid
            if (isValidWord(word, rowMap)) {
                result.add(word);
            }
        }
        
        return result.toArray(new String[0]);
    }
    
    // Helper method isolates the logic, keeping the main loop clean
    private boolean isValidWord(String word, int[] rowMap) {
        if (word.isEmpty()) return true;
        
        // Find which row the very first letter belongs to
        char firstChar = Character.toLowerCase(word.charAt(0));
        int targetRow = rowMap[firstChar - 'a'];
        
        // Ensure every subsequent letter matches that target row
        for (int i = 1; i < word.length(); i++) {
            char currentChar = Character.toLowerCase(word.charAt(i));
            if (rowMap[currentChar - 'a'] != targetRow) {
                return false; 
            }
        }
        
        return true; 
    }
}