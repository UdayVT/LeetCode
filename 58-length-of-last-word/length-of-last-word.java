class Solution {
    public int lengthOfLastWord(String s) 
    {
        int p1 = s.length()-1;
        int p2 = s.length()-1;

        while(!Character.isAlphabetic(s.charAt(p2)))
        {
            p1--;
            p2--;
        }

        while(!Character.isSpace(s.charAt(p1)))
            if(p1==0)
                return p2-p1+1;
            else
                p1--;

        return p2-p1;

    }
}