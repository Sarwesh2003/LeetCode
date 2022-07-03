class Solution {
    public List<List<Integer>> generate(int nr) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<nr;++i){
            list.add(new ArrayList<>());
        }
        for(int i = 0; i < nr; ++i){
            for(int j = 0; j<(i+1);++j){
                if(j == i || j == 0){
                    list.get(i).add(j, 1);
                }
                else{
                    int element = list.get(i-1).get(j-1) + list.get(i-1).get(j);
                    list.get(i).add(element);
                }
            }
        }
        return list;
    }
}