package stack;

import java.util.Stack;

/**
 * Created by rahulmishra on 04/05/16.
 */
public class GFG {

    public static void main(String args[]){
        int arr[] = {8,7,6,5,4,3};
        System.out.print(findLargestDifference(arr));
    }

    private static int findLargestDifference(int []arr) {
         int min = arr[0];
        int largestDifference = -1;
//        s.push(arr[0]);
        for(int i=0;i<arr.length ; i++){
           if(arr[i]>min){
               largestDifference = largestDifference>(arr[i]-min)?largestDifference:(arr[i]-min);
           }
            else{
               min = arr[i];
           }
        }
        return largestDifference;
    }
}
