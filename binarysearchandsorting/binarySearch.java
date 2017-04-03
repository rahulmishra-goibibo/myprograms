package binarysearchandsorting;

/**
 * Created by rahulmishra on 06/02/16.
 */
public class binarySearch {

   static int A[]= {2,3,4,5,6,7,8,9,23,46,58,95};

    public static  void main(String args[]){
        int result = binarySearch(A,0,A.length,23);
        System.out.print(result);
    }

    static int binarySearch(int []A,int start, int end, int numberToFind){
        if(start>end)
            return -1;
        int mid = (start+end)/2;
        if(A[mid]==numberToFind){
            return mid;
        }
        else if(A[mid]>numberToFind){
            return binarySearch(A,start, mid-1,numberToFind);
        }
        else{
            return binarySearch(A,mid+1,end,numberToFind);
        }
    }
}
