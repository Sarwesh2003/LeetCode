class Solution {
    static class Node{
        String word;
        int freq;
        public Node(String word, int freq){
            this.word = word;
            this.freq = freq;
        }
    }
    
    static class Comp implements Comparator<Node>{
        public int compare(Node n1, Node n2){
            if(n1.freq != n2.freq)
                return n1.freq - n2.freq;
            return -n1.word.compareTo(n2.word);
        }
    }
    
    public List<String> topKFrequent(String[] words, int k) {
        PriorityQueue<Node> q = new PriorityQueue<>(k, new Comp());
        Map<String, Integer> map = new TreeMap<>();
        
        for(String word : words){
            if(map.containsKey(word)){
                map.put(word, map.get(word) + 1);
            }else{
                map.put(word, 1);
            }
        }
        
        for(Map.Entry<String, Integer> element : map.entrySet()){
            String w = element.getKey();
            int fr = element.getValue();
            // if(q.size() >= k){
            //     if(fr > q.peek().freq){
            //         q.poll();
            //         q.add(new Node(w, fr));
            //     }
            // }else{
            //     q.add(new Node(w, fr));
            // }
            q.add(new Node(w, fr));
            if(q.size() > k)
                q.poll();
        }
        
        List<String> ans = new ArrayList<>();
        while(q.size() > 0){
            ans.add(q.poll().word);
        }
        Collections.reverse(ans);
        return ans;
    }
}