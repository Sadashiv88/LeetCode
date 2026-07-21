class MyQueue {
    Stack<Integer> st;
    Stack<Integer> gt;

    public MyQueue() {
        st=new Stack<>();
        gt=new Stack<>();
    }
    
    public void push(int x) {
        st.push(x);

    }
    
    public int pop() {
        if(st.size()==1){
            return st.pop();
        }
        while(st.size()>1){
            gt.push(st.pop());

        }
        int x=st.pop();
        while(gt.size()>0) st.push(gt.pop());
        return x;
    }
    
    public int peek() {
        if(st.size()==1){
            return st.peek();
        }
        while(st.size()>1){
            gt.push(st.pop());

        }
        int x=st.peek();
        while(gt.size()>0) st.push(gt.pop());
        return x;
    }
    
    public boolean empty() {
        if(st.size()==0) return true;
        else return false;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */