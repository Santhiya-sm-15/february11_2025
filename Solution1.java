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