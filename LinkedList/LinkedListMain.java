package LinkedList;

import java.util.Scanner;

/**
 * Created by rahulmishra on 28/11/15.
 */
public class LinkedListMain {
    public static void  main(String [] args){

        LinkedList list = new LinkedList();
        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();
    //    int array[] = {10,2,3,18,46,27,5};
        int array1[] = {1,2,3};
        int array2[] = {4,5,6,7,8};
        Scanner s = new Scanner(System.in);
//        System.out.println("Enter the number of values to enter");
//        int total = s.nextInt();
//
//        for(int i = 0;i<total;i++){
//            list.addToList(s.nextInt());
//        }

        for(int i=0;i<array2.length;i++){
            list2.addToList(array2[i]);
        }
        for(int i=0;i<array1.length;i++){
            list1.addToList(array1[i]);
        }
        ListNode l2 = list1.mergeTwoListsAtAlternatePositions(list1.head, list2.head);
//       ListNode second = list1.reverseKNodesAtATime(list1.head, 3, 0);
//        ListNode temp = second;
//        temp.next = null;
       ListNode temp =list1.head;
        while(temp!=null){
            System.out.println(temp.data);
            temp =temp.next;
        }
        System.out.println("==================");
        temp =l2;
        while(temp!=null){
            System.out.println(temp.data);
            temp =temp.next;
        }





    }
}
