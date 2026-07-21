class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n=temperatures.length;
        Stack<Integer> st=new Stack<>();
        int arr[]=new int[n];
        arr[n-1]=0;
        st.push(n-1);
        for(int i=n-1;i>=0;i--){
            while(st.size()>0 && temperatures[st.peek()]<=temperatures[i]){
                st.pop();
            }
            if(st.size()==0) arr[i]=i;
            else arr[i]=st.peek();
            st.push(i);
        }
        int ans[]=new int[n];
        for(int i=0;i<n;i++){
            ans[i]=arr[i]-i;
        }
        return ans;
    }
}