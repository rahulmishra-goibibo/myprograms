package stack;

import java.util.Stack;

/**
 * Created by rahulmishra on 25/12/15.
 */
public class min_no_of_brackets_needed_to_make_an_expression_balanced {

    public static void main(String args[]){
        Stack<Character> s=new Stack<>();
        int total_reversals = 0;
        int total_elements = 0;
        String  arr = "{{{";
        for(int i=0;i<arr.length();i++){
            if(arr.charAt(i)=='{'){
                s.push('{');
            }
            else if(arr.charAt(i)=='}' && !s.isEmpty()){
                s.pop();
            }
            else{
                total_reversals++;
                s.push('{');
            }
        }
        while(!s.isEmpty()){
            s.pop();
            total_elements++;
        }
        if(total_elements%2==0){
            System.out.println((total_elements/2)+total_reversals);
        }
        else{
            System.out.print("Not possible");
        }
    }
}
