class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        int answer=0;

        for(int i=0;i<=n;i++){
            int targetcount=0;
            for(int j=i;j<n;j++){
                if(nums[j]==target){
                    targetcount++;
                }
                int length=j-i+1;
                if(targetcount*2>length){
                    answer++;
                }
            }
        }
        return answer;
    }
}