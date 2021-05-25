package dsa;

public class wildcardMatching {
    /**
     * Wildcard Pattern Matching
     * https://leetcode.com/problems/wildcard-matching/
     * https://practice.geeksforgeeks.org/problems/wildcard-pattern-matching/1/
     * O(N*M) | O(N*M)
     */

    Boolean [][] dp;
    boolean patternMatch(String s, String p, int i, int j){
        //if both i and j have reached to the end
        //this means all the chars are matched
        if(i == s.length() && j == p.length()) return true;
        //if j has reached to the end and i has not reached to the end
        //then this means that there a chars left in the string which do not have match
        if(i != s.length() && j == p.length()) return false;
        //if i has reached to the end and there are chars left in pattern
        //we check if all left chars in patter are *
        //if they are all * they can be replaced by empty char and should return true or else false
        if(i == s.length() && j != p.length()){
            for(int k = j; k < p.length(); k++){
                if(p.charAt(k) != '*') return false;
            }
            return true;
        }
        //checking if our ans has already been stored in our dp array
        //if found return that ans
        if(dp[i][j] != null) return dp[i][j];

        boolean ans = false;

        //if char at pattern is ? or char at pattern and string are same
        //we move our pointer forward by one for both cases as they are a match
        if(p.charAt(j) == '?' || s.charAt(i) == p.charAt(j)){
            ans = patternMatch(s,p,i+1,j+1);
        }
        //if char at patter is '*'
        //we check 3 conditions
        //1. if * implies empty char - we simply increase j without considering ;*'
        //2. if * implies multiple char - we increase i by 1 and j remains same
        //3. if * implies single char - we increase both i and j by 1
        else if(p.charAt(j) == '*'){
            //checks if any of the three conditions are met
            ans = patternMatch(s,p,i,j+1) || patternMatch(s,p,i+1,j) || patternMatch(s,p,i+1,j+1);
        }
        //storing the ans in dp array
        dp[i][j] = ans;
        return ans;

    }
    public boolean isMatch(String s, String p) {
        dp = new Boolean[s.length()][p.length()];
        return patternMatch(s,p,0,0);
    }
}
