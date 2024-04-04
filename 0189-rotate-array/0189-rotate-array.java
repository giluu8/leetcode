class Solution {
   
    public void rotate(int[] nums, int k) {
         k=k%nums.length;
        reverse(nums,0,nums.length-1);//whole array reverse
         reverse(nums,0,k-1);//0-k-1 reverse
              reverse(nums,k,nums.length-1);//last k-last
        
    }
    public  void reverse(int[]nums,int start,int end){
        while(start<end){
            int temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
    }
}