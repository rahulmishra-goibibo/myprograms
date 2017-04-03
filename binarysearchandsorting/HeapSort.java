package binarysearchandsorting;

/**
 * Created by rahulmishra on 07/02/16.
 */
public class HeapSort {
    static int a[] = {38,27,43,3,9,82,10};
    static int length = a.length-1;

    public static void main(String args[]){
        buildHeap(a);
        heapSort(a);
    }

    private static void heapSort(int[] a) {
        for(int i=0;i<a.length;i++) {
            int z = deleteMin(a);
            System.out.println(z);
        }

    }

    private static int deleteMin(int [] a) {
        int z = a[0];
        a[0]=a[length];
        length=length-1;
      //  a.length=a.length-1;
        minHeapify(a,0);
        return  z;
    }

    private static void buildHeap(int[] a) {
        int length = (a.length-2)/2;
        for(int i=length; i>=0;i--){
            minHeapify(a,i);
        }
    }

    private static void minHeapify(int[] a, int i) {
        int left = 2*i+1;
        int right = 2*i+2;
        int min = i;

        if(left<length&& a[left]<=a[min] ){
            min = left;
        }
        if(right<length && a[right]<=a[min] ){
            min = right;
        }

        if(min!=i){
            int temp = a[i];
            a[i] = a[min];
            a[min] = temp;
            minHeapify(a,min);
        }
    }
}
