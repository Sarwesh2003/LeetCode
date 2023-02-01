//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String roman = br.readLine().trim();
            Solution ob = new Solution();
            System.out.println(ob.romanToDecimal(roman));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    // Finds decimal value of a given roman numeral
    public int romanToDecimal(String s) {
        int num = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        char[] ch = s.toCharArray();
        int n = ch.length;
        int i = 0;
        while(i < n){
            switch(ch[i]){
                case 'I':
                    if((i + 1) < n){
                        if(ch[i + 1] == 'V'){
                            num += 4;
                            i += 2;
                        }else if(ch[i + 1] == 'X'){
                            num += 9;
                            i += 2;
                        }else{
                            num += 1;
                            ++i;
                        }
                    }else{
                        num += 1;
                        ++i;
                    }
                break;
                case 'X':
                if((i + 1) < n){
                        if(ch[i + 1] == 'L'){
                            num += 40;
                            i += 2;
                        }else if(ch[i + 1] == 'C'){
                            num += 90;
                            i += 2;
                        }else{
                            num += 10;
                            ++i;
                        }
                    }else{
                            num += 10;
                            ++i;
                        }
                break;
                case 'C':
                    if((i + 1) < n){
                        if(ch[i + 1] == 'D'){
                            num += 400;
                            i += 2;
                        }else if(ch[i + 1] == 'M'){
                            num += 900;
                            i += 2;
                        }else{
                            num += 100;
                            ++i;
                        }
                    }else{
                        num += 100;
                        ++i;
                    }
                break;
                default:
                    num += map.get(ch[i]);
                    ++i;
                break;
            }
        }
        return num;
    }
}