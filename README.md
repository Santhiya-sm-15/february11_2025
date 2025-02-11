# february11_2025
The problem that I solved today

1.Given two strings s and part, perform the following operation on s until all occurrences of the substring part are removed: Find the leftmost occurrence of the substring part and remove it from s. Return s after removing all occurrences of part. A substring is a contiguous sequence of characters in a string.

Code:
class Solution {
    public String removeOccurrences(String s, String part) {
        int i;
        Stack<Character> st=new Stack<>();
        int n=s.length();
        int m=part.length();
        for(i=0;i<n;i++)
        {
            if(s.charAt(i)==part.charAt(m-1))
            {
                int j=m-2;
                StringBuilder sb=new StringBuilder();
                while(!st.isEmpty() && j>=0 && st.peek()==part.charAt(j))
                {
                    sb.insert(0,st.pop());
                    j--;
                }
                if(j!=-1)
                {
                    j=0;
                    while(j<sb.length())
                        st.push(sb.charAt(j++));
                    st.push(s.charAt(i));
                }
            }
            else
                st.push(s.charAt(i));
        }
        StringBuilder res=new StringBuilder("");
        while(!st.isEmpty())
            res.insert(0,st.pop());
        return res.toString();
    }
}
