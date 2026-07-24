class MedianFinder {
    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;
    public MedianFinder() {
        right=new PriorityQueue<>();
        left=new PriorityQueue<>(Comparator.reverseOrder());

    }
    
    public void addNum(int num) {
        left.add(num);
        right.add(left.remove());

        if(right.size()>left.size()){
            left.add(right.remove());
        }
    }
    
    public double findMedian() {
        if(right.size()==left.size()){
            return (left.peek()+right.peek())/2.0;
        }else{
            return left.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */