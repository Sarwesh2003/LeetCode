class Solution {
    public int[][] merge(int[][] arr) {
        // int[][] ans = new int[arr.length][2];
        ArrayList<int[]> list = new ArrayList<>();
        Arrays.sort(arr, (a,b) -> a[0] - b[0]);
        int start = arr[0][0];
        int end = arr[0][1];
        for(int[] a:arr){
            if(end >= a[0]){
                end = Math.max(end, a[1]);
            }else{
                list.add(new int[]{start,end});
                start = a[0];
                end = a[1];
            }
        }
        list.add(new int[]{start,end});
        return list.toArray(new int[0][]);
    }
}