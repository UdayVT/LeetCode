class Solution {
    class DataStructure implements Comparable<DataStructure>
    {
        int indice = 0;
        int value = 0;
        DataStructure(int indice, int value)
        {
            this.indice = indice;
            this.value = value;
        }

        public int compareTo(DataStructure d)
        {
            return value-d.value;
        }
    }
    public int[] maxSubsequence(int[] nums, int k) 
    {
        PriorityQueue<DataStructure> prq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i<nums.length;i++)
            prq.add(new DataStructure(i,nums[i]));    

        int[] answerIndice = new int[k];
        
        for(int i = 0; i<k;i++)
            answerIndice[i] = prq.poll().indice;

        Arrays.sort(answerIndice);

        int[] answer = new int[k];
        for(int i = 0; i<k;i++)
            answer[i] = nums[answerIndice[i]];

        return answer;
    }
}