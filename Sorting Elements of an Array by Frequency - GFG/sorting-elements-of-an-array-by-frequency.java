/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t-- > 0){
		    int n = s.nextInt();
		    int[] arr = new int[n];
		    for(int i = 0; i < n; ++i){
		        arr[i] = s.nextInt();
		    }
		    Arrays.sort(arr);
		    HashMap<Integer, Integer> map = new HashMap<>();
		    PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
		        public int compare(int[] a, int[] b){
		            if(b[1] == a[1]){
		                return a[0] - b[0];
		            }
		            return b[1] - a[1];
		        }
		    });
		    for(int i : arr){
		        map.put(i, map.getOrDefault(i, 0) + 1);
		    }
		    for(Map.Entry<Integer, Integer> m : map.entrySet()){
		        pq.add(new int[]{m.getKey(), m.getValue()});
		    }
		    
		    int idx = 0;
		    while(!pq.isEmpty()){
		        int[] temp = pq.poll();
		        int freq = temp[1];
		        int num = temp[0];
		        while(freq-- > 0){
		            arr[idx++] = num;
		        }
		    }
		    for(int i : arr){
		        System.out.print(i +" ");
		    }
		    System.out.println();
		}
	}
}