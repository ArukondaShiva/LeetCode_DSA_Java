class MedianFinder {
    
    PriorityQueue<Integer> s;
    PriorityQueue<Integer> g;

    public MedianFinder() {
        s = new PriorityQueue<>(Collections.reverseOrder());
        g = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(s.size()>g.size()){
            s.add(num);
            g.add(s.poll());
        }else{
            g.add(num);
            s.add(g.poll());
        }
    }
    
    public double findMedian() {
        if(s.size()>g.size()){
            return s.peek();
        }else{
            return (s.peek()+g.peek())/2.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */