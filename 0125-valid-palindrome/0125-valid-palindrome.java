class Solution {
    public boolean isPalindrome(String s) {
        // Remove all non-alphanumeric characters and convert to lowercase
        String cleaned = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        
        // Reverse the cleaned string using StringBuilder
        String reversed = new StringBuilder(cleaned).reverse().toString();
        
        // Check if the cleaned string is equal to its reversed version
        return cleaned.equals(reversed);
    }
}