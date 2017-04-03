package stack;

import java.util.Stack;

/**
 * Created by rahulmishra on 27/12/15.
 */
public class reverseStack {
    public static void main(String args[]){
        int arr[]= {1,2,3,4};
        Stack<Integer> s = new Stack<>();
        for(int i=0;i<arr.length;i++){
            s.push(arr[i]);
        }
        s= reversestack(s);
        for(int i=0;i<arr.length;i++){
           System.out.print(s.pop());
        }
    }

    private static Stack<Integer> reversestack(Stack<Integer> s) {
        if(s.isEmpty()){
            return null;
        }
        int i = s.pop();
        s = reversestack(s);
        if(s==null){
            s = new Stack<>();
        }
        s.push(i);
        return s;
    }
}
