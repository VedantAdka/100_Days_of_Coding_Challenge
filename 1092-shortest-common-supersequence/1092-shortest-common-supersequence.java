class Solution {
    public String shortestCommonSupersequence(String s, String w) {
        int n=s.length();
        int m=w.length();
        int[][] dp=new int[n+1][m+1];
        for(int i=0;i<=n;i++){
            dp[i][0]=0;
        }
        for(int j=0;j<=m;j++){
            dp[0][j]=0;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s.charAt(i-1)==w.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        int i=n;
        int j=m;
        String ans="";
        while(i>0 && j>0){
            if(s.charAt(i-1)==w.charAt(j-1)){
                ans+=s.charAt(i-1);
                i--;
                j--;
            }
            else if(dp[i-1][j]>dp[i][j-1]){
                ans+=s.charAt(i-1);
                i--;
            }
            else{
                ans+=w.charAt(j-1);
                j--;
            }
        }
        while(i>0){
            ans+=s.charAt(i-1);
            i--;
        }
        while(j>0){
            ans+=w.charAt(j-1);
            j--;
        }
        String rev=new StringBuilder(ans).reverse().toString();
        return rev;
    }
}