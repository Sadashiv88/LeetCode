class Solution {
    public void helper(int start,int end,int n,List<String> ans,StringBuilder curr){
        if(curr.length()==2*n){
            ans.add(curr.toString());
            return;
        }
        if(start<n){
            curr.append('(');
            helper(start+1,end,n,ans,curr);
            curr.deleteCharAt(curr.length() - 1);
        }
        if(end<start){
            curr.append(')');
            helper(start,end+1,n,ans,curr);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> ans=new ArrayList<>();
        helper(0,0,n,ans,new StringBuilder());
        return ans;
    }
}