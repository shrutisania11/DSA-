class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);//sort the array to apply the greedy approach 
        arr[0]=1;// manditory condition the first element should be 1

        for(int i=1;i<arr.length;i++){//traverse the whole array from the index 1 as index o is 1 already 
            arr[i]=Math.min(arr[i],arr[i-1]+1);// min(current,previous+1)

        }
        return arr[arr.length-1];//Since the array is sorted, the last element is the maximum

        
    }
}