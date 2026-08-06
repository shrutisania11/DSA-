class Solution {
    public int smallestNumber(int n, int t) {
        while(true){
        int product =1;
        int temp =n;

        while(temp>0){
        product *=(temp%10); //get the last digit 
        temp/=10; // remove the last digit 
        
        }
        if(product%t==0){
            return n;

        }
        n++;
        }   
    }
}