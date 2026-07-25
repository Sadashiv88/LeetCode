class Solution {
    public int maxProduct(int n) {
        int temp=n;
        PriorityQueue<Integer> q=new PriorityQueue<>(Comparator.reverseOrder());
        while(temp!=0){
            int t=temp%10;
            q.add(t);
            temp=temp/10;
        }
        if(q.size()==1) return q.peek();
        int a1=q.remove();
        int a2=q.remove();
        return a1*a2;
    }
}