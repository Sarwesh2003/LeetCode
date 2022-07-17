class Solution {
    public String reverseWords(String str) {
        String[] arr = str.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = arr.length-1; i>=0; --i){
            String s = arr[i].trim();
            if(s != null || !s.isEmpty() || !s.equals(" ") ){
                sb.append(s+" ");
            }
            sb = new StringBuilder(sb.toString().trim());
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}