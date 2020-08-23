class Solution {
    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }
        
        for (int i = s.length(); i >= 0; i--) {
            for (int j = 0; j + i <= s.length(); j++) {
                if (isPalindrome(s.substring(j, j+i))) {
                    return s.substring(j, j+i);
                }
            }
        }
        
        return s.substring(0,1);
    }
    
    static boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j){
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true; 
    }
}