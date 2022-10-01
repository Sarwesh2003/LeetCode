class MedianFinder {
    double median;
    PriorityQueue<Double> min;
    PriorityQueue<Double> max;
    ArrayList<Integer> list;
    public MedianFinder() {
        min = new PriorityQueue<>();
        max = new PriorityQueue<>(Collections.reverseOrder());
        median = -1;
        list = new ArrayList<>();
    }
    
    public void addNum(int element) {
        switch(signum(max.size(), min.size())){
            case 0:
                if(element > median){
                    min.add((double)element);
                    median = min.peek();
                }else{
                    max.add((double)element);
                    median = max.peek();
                }
            break;
            case 1:
                if(element > median){
                    min.add((double)element);
                    median = (min.peek() + max.peek()) / 2;
                }else{
                    min.add(max.poll());
                    max.add((double)element);
                    median = (min.peek() + max.peek()) / 2;
                }
            break;
            
            case -1:
                if(element > median){
                    max.add(min.poll());
                    min.add((double)element);
                    median = (min.peek() + max.peek()) / 2;
                }else{
                    max.add((double)element);
                    median = (min.peek() + max.peek()) / 2;   
                }
            break;
        }
    }
    private int signum(int a, int b){
        if(a == b)return 0;
        else if(a > b) return 1;
        else return -1;
    }
    public double findMedian() {
        return median;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */