class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k<=1){ //the product cant be less than one as all the no. are positive
            return 0;
        }
        int left=0;
        int count=0;
        int product=1;
        for(int right=0;right<nums.length;right++){
            product *=nums[right];
            while(product>=k){
                product/=nums[left];
                left++;
            }
            count+=right-left+1;
        }
        return count;
    }
}