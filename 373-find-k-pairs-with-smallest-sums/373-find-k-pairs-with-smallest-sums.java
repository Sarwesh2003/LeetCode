class Solution {
    static class Node{
        int n2;
        int x, y;
        public Node(int x, int y, int n2){
            this.x = x;
            this.y = y;
            this.n2 = n2;
        }
    }
    static class Comp implements Comparator<Node>{
        public int compare(Node n1, Node n2){
            return (n1.x + n1.y) - (n2.x + n2.y);
        }
    }
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comp());
        List<List<Integer>> ans = new ArrayList<>();
        
        for(int i = 0; i < nums1.length && i < k; ++i){
            pq.add(new Node(nums1[i], nums2[0], 0));
        }
   

        for(int i = 0; i < k && pq.size() > 0; ++i){
            Node n = pq.poll();
            ans.add(List.of(n.x,n.y));
            int idx = n.n2;
            
            if(idx < nums2.length - 1){
                pq.add(new Node(n.x, nums2[idx + 1], idx + 1));
            }
            
        }
        return ans;
    }
}