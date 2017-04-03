package binarysearchandsorting;

/**
 * Created by rahulmishra on 06/02/16.
 */
public class insertionSort {

    public static void main(String args[]){
        int a[] = {12,11,13,5,6};

        for(int i=1;i<a.length;i++){
            int j = i-1;
            int key = a[i];

            while(j>=0 && a[j]>key){
                a[j+1] = a[j];
                j--;
            }
            a[j+1] = key;
        }

        for(int k=0;k<a.length;k++){
            System.out.println(a[k]);
        }
    }
}
