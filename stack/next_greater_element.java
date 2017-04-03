package stack;

import java.util.Stack;

/**
 * Created by rahulmishra on 27/12/15.
 */
public class next_greater_element {

    public static void main(String args[]){
        int arr[] = {11,13,21,3};
        Stack<Integer> s = new Stack<>();
        s.push(0);

        for(int i=1;i <arr.length;i++){
            while(!s.isEmpty() && arr[s.peek()]<arr[i]){
                int z=s.pop();
                System.out.println("Next Greater Element of"+arr[z]+" is "+arr[i]);
            }
            s.push(i);
        }
        while(!s.isEmpty()){
            int i = s.pop();
            System.out.println("NGE of "+arr[i]+" is -1");
        }

    }
}
