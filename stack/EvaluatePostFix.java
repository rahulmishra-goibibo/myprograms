import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main (String[] args) {
        //code
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();

        for(int i=0; i<t; i++) {
            int n = s.nextInt();
            int target = s.nextInt();
            int array[] = new int[n];

            int j;

            for(j=0; j<n ; j++) {
                array[j] = s.nextInt();
            }

            int start = 0;
            int end = 0;
            int minSI = -1;
            int minEI = -1;
            int min = Integer.MAX_VALUE;
            int sum = 0;

            while(end < n) {
                sum = sum + array[end];

                if(sum == target) {
                    if(end-start<min) {
                        min = end - start;
                        minEI = end+1;
                        minSI = start+1;
                        System.out.println(minSI+" "+minEI);
                        break;
                    }

                }

                else if(sum > target) {
                    while(sum > target && start<=end) {
                        sum = sum-array[start];
                        start++;
                    }
                    if(start>end) {
                        end = start;
                        sum = 0;
                    }
                    else if(sum <= target) {
                        sum = sum-array[end];
                    }

                }

                else {
                    end++;
                }
            }

            if(minEI == -1) {
                System.out.println("-1");
            }


        }
    }
}