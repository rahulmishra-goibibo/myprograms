package binarysearchandsorting;

/**
 * Created by rahulmishra on 07/02/16.
 */
public class mergeSort {

    static int a[] = {38,27,43,3,9,82,10};

    public static void main(String args[]){
        mergesort(a,0,a.length-1);

        for(int i=0;i<a.length; i++){
            System.out.println(a[i]);
        }
    }

    private static void mergesort(int[] a, int start, int end) {
        if(start>=end)
            return;
        int mid = (start+end)/2;
        mergesort(a,start,mid);
        mergesort(a,mid+1,end);
        merge(a,start,mid+1,end);
    }

    private static void merge(int[] a, int start, int startSecondArray, int endArray) {
        int lengthFirstArray = startSecondArray-start;
        int lengthSeconArray = endArray-startSecondArray+1;

        int tempArray1[] = new int[lengthFirstArray];
        int tempArray2[] = new int[lengthSeconArray];

        int l1 = start;
        int l2 = startSecondArray;

        for(int i=0;i<lengthFirstArray;i++){
            tempArray1[i] = a[l1];
            l1++;
        }

        for(int i=0;i<lengthSeconArray;i++){
            tempArray2[i] = a[l2];
            l2++;
        }

        int index = start;
        l1 = 0;
        l2 = 0;

        while(l1<lengthFirstArray && l2<lengthSeconArray){
            if(tempArray1[l1]<=tempArray2[l2]){
                a[index] = tempArray1[l1];
                l1++;
                index++;
            }
            else{
                a[index] = tempArray2[l2];
                l2++;
                index++;
            }
        }

        while(l1<lengthFirstArray){
            a[index] = tempArray1[l1];
            l1++;
            index++;
        }

        while (l2<lengthSeconArray){
            a[index] = tempArray2[l2];
            l2++;
            index++;
        }

    }

}
