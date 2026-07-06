class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] ans = new int[n];

        if(k==0){
            return ans;
        }
        int start,end;
        if(k>0){
            start=1;
            end =k;
        }else{
            start=n+k;
            end=n-1;
        }
        int windowsum=0;
        for(int i=start;i<=end;i++){
            windowsum +=code[i%n];
        }
        for(int i=0;i<n;i++){
            ans[i]=windowsum;
            windowsum-=code[start%n];
            start++;
            end++;
            windowsum+=code[end%n];
        }
        return ans;
    }
}