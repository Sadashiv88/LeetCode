class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder st=new StringBuilder("");
        int left=0;
        int n=s.length();
        for(int i=0;i<spaces.length;i++){
            st.append(s.substring(left,spaces[i]));
            left=spaces[i];
            st.append(" ");
        }
        st.append(s.substring(left,n));
        return st.toString();
    }
}