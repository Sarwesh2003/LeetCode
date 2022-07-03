class Solution {
    public void setZeroes(int[][] matrix) {
        ArrayList<Integer> rows = new ArrayList<>();
        ArrayList<Integer> cols = new ArrayList<>();
        for(int i=0; i<matrix.length; ++i){
            for(int j=0; j<matrix[i].length; ++j){
                if(matrix[i][j] == 0){
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        
        for(int r:rows){
            for(int c:cols){
                calc(matrix, r, c);
            }
        }
        
    }
    
    public void calc(int[][] arr, int i, int j){
        for(int col=0; col<arr[i].length; ++col){
            arr[i][col]=0;
        }
        for(int row=0; row<arr.length; ++row){
            arr[row][j]=0;
        }
    }
}