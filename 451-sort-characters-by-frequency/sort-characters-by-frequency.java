class Solution {
    class DataStructure implements Comparable<DataStructure>
    {
        char x;
        int frequency; 
        
        DataStructure(char x, int frequency)
        {
            this.x = x;
            this.frequency = frequency;
        }

        public int compareTo(DataStructure d)
        {
            return frequency - d.frequency;
        }
    }
    public String frequencySort(String s) 
    {
        HashMap<Character,Integer> map = new HashMap<>();

        for(int i = 0;i<s.length();i++)
        {
            if(map.containsKey(s.charAt(i)))
                map.put(s.charAt(i),map.get(s.charAt(i))+1);
            else
                map.put(s.charAt(i),1);
        }

        PriorityQueue<DataStructure> prq = new PriorityQueue<>(Collections.reverseOrder());

        Object[] keys = map.keySet().toArray();

        for(int i = 0; i<keys.length;i++)
            prq.add(new DataStructure((char)keys[i],map.get(keys[i])));

        String answer = "";
        for(int i = 0; i<keys.length;i++)
        {
            DataStructure d = prq.poll();
            for(int j = 0;j<d.frequency;j++)
                answer += d.x;
        }

        return answer;
    }
}