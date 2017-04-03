package stack;

import java.util.Stack;

/**
 * Created by rahulmishra on 25/12/15.
 */
public class length_of_the_longest_valid_substring {

    public static void main(String args[]){
        Stack<Character> s = new Stack<>();
        int current_count = 0;
        int max_count = 0;

        String arr = "((()";

        for(int i=0;i<arr.length();i++){
            if(arr.charAt(i)=='('){
                s.push('(');
            }
            else if(arr.charAt(i)==')' && !s.isEmpty()){
                s.pop();
                current_count+=2;
            }
            else{
                if(current_count>max_count){
                    max_count = current_count;
                }
                current_count = 0;
            }
        }
        if(current_count>max_count){
            max_count = current_count;
        }
        System.out.print(max_count);
    }
}
