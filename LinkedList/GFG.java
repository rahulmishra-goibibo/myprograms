package LinkedList;

import java.util.*;
import java.lang.*;
import java.io.*;

class Linked {
    Node head = null;

    void addNode(int data) {
        if (head == null) {
            head = new Node(data);
        }
        else {
            Node temp = head;
            while(temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Node(data);
        }
    }

    void printAll() {
        Node temp = head;
        while(temp!=null) {
            System.out.print(temp.data);
            System.out.print(' ');
            temp = temp.next;
        }
        System.out.println();
    }

    int checkPalindrome() {
        Node temp = head;

        return 0;
    }

    void seperateOddEven() {

        Node lastNode = head;
        int count = 0;

        while(lastNode!=null && lastNode.next!=null) {
            lastNode = lastNode.next;
            count ++;
        }

        Node prev = null;
        Node temp = head;
        Node tempLastNode = lastNode;
        int tempCount = 0;

        while(tempCount<=count) {
            tempCount++;
            if(temp.data %2!=0) {
                tempLastNode.next = temp;
                if(temp == head) {
                    head = temp.next;
                    temp.next = null;
                    temp = head;
                }
                else {
                    prev.next = temp.next;
                    temp.next = null;
                    temp = prev.next;
                }
                tempLastNode = tempLastNode.next;
            }
            else{
                prev = temp;
                temp = temp.next;
            }

        }

    }

}

class Node {
    int data;
    Node next = null;
    Node (int data) {
        this.data = data;
    }
}

class GFG {
    public static void main (String[] args) {
        //code
        int numberOfTestCases;
        Scanner s = new Scanner(System.in);
        numberOfTestCases = s.nextInt();

        for(int i=0; i<numberOfTestCases; i++) {
            int numberOfElements = s.nextInt();
            Linked list = new Linked();

            for(int j = 0; j<numberOfElements; j++) {
                list.addNode(s.nextInt());
            }
            list.seperateOddEven();
            list.printAll();
        }
    }
}