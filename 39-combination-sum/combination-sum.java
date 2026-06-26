class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> answer = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), answer);
        return answer;
    }

    public void backtrack(int[] candidate,int target,int index,List<Integer> current,List<List<Integer>> answer){
        if(target==0){//we have achieved the target
            answer.add(new ArrayList<>(current));
            return;
        }
        if(target<0){
            return;
        }
        for(int i = index;i<candidate.length;i++)
    {// start from index not i so that to avoid duplicate combinations 
        current.add(candidate[i]);
        backtrack(candidate, target - candidate[i], i, current, answer);
        current.remove(current.size() - 1);//undo the last choice 
    }
    }
}