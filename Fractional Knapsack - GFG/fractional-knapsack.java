//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}

class GfG {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int w = Integer.parseInt(inputLine[1]);
            Item[] arr = new Item[n];
            inputLine = br.readLine().trim().split(" ");
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Item(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            System.out.println(String.format("%.2f", new Solution().fractionalKnapsack(w, arr, n)));
        }
    }
}
// } Driver Code Ends


/*
class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
*/
class CustomComp implements Comparator<Item>{
    public int compare(Item i1, Item i2){
        double diff1 = (double)i1.value / (double)i1.weight;
        double diff2 = (double)i2.value / (double)i2.weight;
        
        if(diff1 < diff2){
            return 1;
        }else if(diff1 > diff2){
            return -1;
        }else{
            return 0;
        }
    }
}
class Solution
{
    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int W, Item arr[], int n) 
    {
        Arrays.sort(arr, new CustomComp());
        double val = 0;
        for(int i = 0; i < n; ++i){
            if(arr[i].weight <= W){
                W -= arr[i].weight;
                val += arr[i].value;
            }else{
                double diff = (double)arr[i].value / (double)arr[i].weight;
                val  += diff * (double)W;
                break;
            }
        }
        return val;
    }
}