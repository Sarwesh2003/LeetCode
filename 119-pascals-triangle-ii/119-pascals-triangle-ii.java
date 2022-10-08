class Solution {
    public List<Integer> getRow(int rowIndex) {
//         List<List<Integer>> list = new ArrayList<>();
//         // 1st row
//         list.add(new ArrayList<>(Arrays.asList(1)));
        
//         for(int i = 1; i <= rowIndex; ++i){
//             List<Integer> lastRow = list.get(i - 1);
//             List<Integer> curr = new ArrayList<>();
//             curr.add(1);
//             for(int j = 1; j < (i); ++j){
//                 curr.add(lastRow.get(j - 1) + lastRow.get(j));
//             }
//             curr.add(1);
//             list.add(curr);
//         }
//         return list.get(rowIndex);
        List<Integer> list = new ArrayList<>();
        double ncr = 1.0;
        for(int i = 0; i <= rowIndex; ++i){
            list.add((int)ncr);
            ncr = (ncr * (rowIndex - i)) / (i + 1);
        }
        return list;
    }
}