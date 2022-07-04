class Solution {
    public void rotate(int[][] matrix) {
        if(matrix.length <= 1){
            return;
        }
        for(int i=0;i<matrix.length;++i){
            for(int j=i;j<matrix[i].length;++j){
                swap(matrix, i, j);
            }
        }
        
        for(int i=0;i<matrix.length;++i){
            reverse(matrix[i]);
        }
        
    }
    
    public void swap(int[][] arr, int i, int j){
        int temp = arr[i][j];
        arr[i][j] = arr[j][i];
        arr[j][i] = temp;
    }
    
    public void reverse(int[] arr){
        int i=0;
        int j=arr.length-1;
        
        while(i<j){
            int temp = arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            ++i;
            --j;
        }
    }
}