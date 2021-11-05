package com.aditya.dp;
/* Given two string s1 and s2 . Find min operation(delete, insert or replace) performed on s1 to
* convert to s2  */
public class EditDistance {
    //TC: O(n*m) || SC: O(n*m) where n,m are length of s1 and s2 resp.
    public static int findMinEditOperation(String s1, String s2){
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        //When s2 is empty, min op will be equal to length of s1
        for(int i1=0;i1<=s1.length();i1++){
            dp[i1][0]=i1;
        }
        //When s1 is empty, min op will be equal to length of s2
        for(int i2=0;i2<=s2.length();i2++){
            dp[0][i2]=i2;  //since s2 is along column
        }

        for(int i1=1;i1<=s1.length();i1++){
            for(int i2=1;i2<=s2.length();i2++){
                if(s1.charAt(i1-1)==s2.charAt(i2-1)){
                    dp[i1][i2]=dp[i1-1][i2-1];
                }else {
                    dp[i1][i2]=1+Math.min(dp[i1-1][i2],  //delete one char of s1
                         Math.min(dp[i1][i2-1],  //insert one char in s1
                             dp[i1-1][i2-1])); //replace one char of s1
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }

    public static void main(String[] args) {
        System.out.println("Min Op : "+findMinEditOperation("abc", "yabd"));
    }
}
