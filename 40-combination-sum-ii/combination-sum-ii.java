class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> answer = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), answer);
        return answer;   
    }

   private void backtrack(int[] candidates,
                           int target,
                           int index,
                           List<Integer> current,
                           List<List<Integer>> answer){
        if(target==0){
            answer.add(new ArrayList<>(current));
            return;
        }
        if(target<0){
            return;
        }
        for(int i=index;i<candidates.length;i++){
            if(i>index && candidates[i]==candidates[i-1]){
                continue;
            }
            current.add(candidates[i]);

            backtrack(candidates,target-candidates[i],i+1,current,answer);
            current.remove(current.size()-1);
        }
    }
}