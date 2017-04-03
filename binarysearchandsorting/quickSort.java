package binarysearchandsorting;

/**
 * Created by rahulmishra on 07/02/16.
 */
public class quickSort {

    static int a[] = {38,27,43,3,9,82,10};

    public static void main(String args[]){
        quicksort(a,0,a.length-1);

        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }

    private static void quicksort(int[] a, int start, int end) {
        if(start<end) {
            int partitonIndex = partition(a, start, end);
            quicksort(a, start, partitonIndex - 1);
            quicksort(a, partitonIndex + 1, end);
        }
    }

    private static int partition(int[] a, int start, int end) {

        int pivot = a[start];
        int left = start+1;
        int right= end;

        while(left<right){
            while (left<=end && a[left]<pivot ){
                left++;
            }
            while(right>start && a[right]>pivot){
                right--;
            }

            if(left<right){
                int temp = a[left];
                a[left] = a[right];
                a[right] = temp;
//                left++;
//                right--;
            }

        }
        int temp = a[right];
        a[right] = pivot;
        a[start] = temp;
        return right;
    }
}
