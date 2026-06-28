class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);//sort it so that the duplicates become adjacent
        
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(nums,0,new ArrayList<>(),ans);
        return ans;   
    }
    public void backtrack(int[] nums,int index, List<Integer> current,List<List<Integer>> ans){
        ans.add(new ArrayList(current));
        for(int i=index;i<nums.length;i++){
        if(i>index && nums[i]==nums[i-1]){
            continue;
        }
        current.add(nums[i]);
        backtrack(nums,i+1,current,ans);
        current.remove(current.size()-1);
       

        }
    }
}