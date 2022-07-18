public class SolutionForPalindrome {
    //Given a string s, return the longest palindromic substring in s  - DP
    public String longestPalindrome(String s) {
        int n = s.length();
        int maxLenPali = 1;
        int maxStart = 0;
        int maxEnd = 0;
        if(s.length() == 0) return "";
        boolean[][] ispali = new boolean[n][n];
        // initialize the 2 diagonals for (i,i) and (i,i+1) cases
        for(int i=0; i<n; i++){
            ispali[i][i] = true;
        }
        for(int i=0; i<n-1; i++){
            boolean is2LenPali = s.charAt(i) == s.charAt(i+1);
            ispali[i][i+1] = is2LenPali;
            if(is2LenPali){
                maxLenPali = 2;
                maxStart=i;
                maxEnd=i+1;
            }
        }
        // build the rest of the cases of ispali[i][j] on top of the base cases
        for(int i=n-1; i>=0; i--){
            for(int j=i+1; j<n; j++){
                if(s.charAt(i) == s.charAt(j)){
                    if((j-i <= 2) ||ispali[i+1][j-1]){
                        ispali[i][j] = true;
                        if(j-i+1 > maxLenPali) {
                            maxLenPali = j - i + 1;
                            maxStart = i;
                            maxEnd = j;
                        }
                    }
                }
            }
        }
        return s.substring(maxStart,maxEnd+1);
    }
}

