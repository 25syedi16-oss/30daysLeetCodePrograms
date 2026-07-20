class Solution {
    public int lengthOfLastWord(String s) {
        // Trim trailing/leading spaces and split by one or more spaces
        String[] words = s.trim().split("\\s+");
        
        // Return the length of the last word in the array
        return words[words.length - 1].length();
    }
}