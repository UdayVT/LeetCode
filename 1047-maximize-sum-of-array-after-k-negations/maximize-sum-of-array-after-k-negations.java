class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) 
    {
         PriorityQueue<Integer> prq = new PriorityQueue<>();

         int sum = 0;
         for(int i = 0; i<nums.length;i++)
         {
            prq.add(nums[i]);
            sum += nums[i];
         }

         for(int j = 0; j<k;j++)
         {
            int x = prq.poll();
            sum -= x;
            sum -= x;
            prq.add(-x);
         }

         return sum;

    }
}