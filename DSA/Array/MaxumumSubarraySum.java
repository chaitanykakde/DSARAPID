class Solution {
    public int maxSubarraySum(int[] arr, int k) {
        // Code here
        int j=0;
        int max=Integer.MIN_VALUE;
        int sum=0;
        
        //first window 
        for(int i=0;i<k;i++){
            sum+=arr[i];
        }
        max=sum;
        
        //slide window
        for(int i=k;i<arr.length;i++){
            sum+=arr[i];
            sum-=arr[i-k];
            
            max=Math.max(sum,max);
        }
        return max;
    }
}