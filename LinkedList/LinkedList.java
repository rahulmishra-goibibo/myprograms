package LinkedList;

/**
 * Created by rahulmishra on 28/11/15.
 */
public class LinkedList {
    ListNode head = null;
    ListNode current = null;

    public LinkedList() {

    }

    public LinkedList(int data) {
        head = new ListNode();
        head.data = data;
        head.next = null;
        current = head;
    }

    public void addToList(int data) {
        if (head == null) {
            head = new ListNode();
            head.next = null;
            head.data = data;
            current = head;
            return;
        }
        current.next = new ListNode();
        current = current.next;
        current.data = data;
        current.next = null;
    }

    public void removeDuplicates(ListNode head) {
        ListNode temp = head;

        while(temp!=null && temp.next!=null) {
            if(temp.data == temp.next.data) {
                temp.next = temp.next.next;
            }
            else{
                temp = temp.next;
            }
        }
    }

    public ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null) {
            fast = fast.next;
            if (fast != null) {
                slow = slow.next;
                fast = fast.next;
            }
        }
        ListNode t = slow;
        slow = slow.next;
        t.next = null;
        head = mergeSort(head);
        slow = mergeSort(slow);

        ListNode merged = merge(head, slow);
        return merged;
    }

    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode temp = new ListNode();
        ListNode fake = temp;
        while (head1 != null || head2 != null) {
            if (head1 == null) {
                temp.next = head2;
                head2 = head2.next;
            } else if (head2 == null) {
                temp.next = head1;
                head1 = head1.next;
            } else {
                if (head1.data <= head2.data) {
                    temp.next = head1;
                    head1 = head1.next;
                } else {
                    temp.next = head2;
                    head2 = head2.next;
                }
            }
            temp = temp.next;

        }
        return fake.next;
    }

   public ListNode reverseLinkedList(ListNode node){
    ListNode current, next,prev;

       current = node;
       prev = null;

       while(current!=null){
           next = current.next;
           current.next = prev;
           prev = current;
           current = next;
       }

       return prev;
   }

    public ListNode reverseLinkedListByRecursion(ListNode node){
       if(node == null || node.next == null) {
           this.head = node;
           return node;
       }
       ListNode temp = reverseLinkedListByRecursion(node.next);
       temp.next = node;
       return node;

    }

    public ListNode alternatingSplit(ListNode node) {
        ListNode secondNode = null;
        ListNode prev = node;

        if(node == null || node.next == null) {
            return null;
        }

        int counter = 0;
        ListNode secondHead = null;
        while(node!=null){
            ListNode temp = node.next;

            if(counter%2 !=0) {
                if(secondNode == null){
                    secondNode = node;
                    prev.next = secondNode.next;
                    secondHead = secondNode;
                    secondNode.next = null;
                }
                else{
                    secondNode.next = node;
                    prev.next = node.next;
                    secondNode = secondNode.next;
                    secondNode.next = null;
                }

            }
            counter++;
            prev = node;
            node = temp;
        }
        return secondHead;


    }

    public ListNode mergeTwoListsAtAlternatePositions(ListNode head1, ListNode head2) {
        while(head1!=null) {
            if(head2 == null) {
                return head2;
            }
            ListNode temp = head1.next;
            head1.next = head2;
            head2 = head2.next;
            head1.next.next = temp;
            head1 = temp;

        }
        return head2;
    }

    public ListNode addTwoLists(ListNode first, ListNode second)
    {
        // Your code here
        ListNode resultList = null;
        ListNode currentState = null;
        int sum = 0;
        int carry = 0;
        int result = 0;
        while(first!=null && second != null) {
            sum = first.data + second.data + carry;
            if(sum>=10){
                carry = sum/10;
                sum = sum %10;
            }
            else{
                carry = 0;
            }
            result = sum;
            if(resultList == null) {
                resultList = new ListNode();
                resultList.data = result;
                resultList.next = null;
                currentState = resultList;
            }
            else{
                currentState.next = new ListNode();
                currentState.next.data = result;
                currentState = currentState.next;
                currentState.next = null;
            }
            first = first.next;
            second = second.next;
        }

        while(first!=null) {
            sum = first.data + carry;
            if(sum>=10){
                carry = sum/10;
                sum = sum %10;
            }
            else{
                carry = 0;
            }
            result = sum;
            currentState.next = new ListNode();
            currentState.next.data = result;
            currentState = currentState.next;
            currentState.next = null;
            first = first.next;
        }

        while(second!=null) {
            sum = second.data + carry;
            if(sum>=10){
                carry = sum/10;
                sum = sum %10;
            }
            else{
                carry = 0;
            }
            result = sum;
            currentState.next = new ListNode();
            currentState.next.data = result;
            currentState = currentState.next;
            currentState.next = null;
            second = second.next;
        }
        if(carry>0){

        }
        return resultList;
    }

    public ListNode reverseKNodesAtATime(ListNode head, int k, int counter) {
        if(head == null || head.next == null) {
            return head;
        }
        int count = 0;
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = head.next;

        while (curr!=null && count<k) {
            if(counter % 2 == 0) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
                count++;
            }
            else{
                prev = curr;
                curr = curr.next;
                count++;
            }
        }
        if(counter%2 == 0)
        head.next = reverseKNodesAtATime(curr, k, counter+1);
        else{
            prev.next = reverseKNodesAtATime(curr, k, counter+1);
            return head;
        }
        return prev;
    }

    public ListNode rearrangeALinkedListAlternately(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode head1 = head;
        System.out.print("i am here");
        ListNode middle = findMiddlePointOfLinkedList(head);
        ListNode head2 = reverseLinkedList(middle.next);
        middle.next = null;
        ListNode curr = new ListNode();
        ListNode temp = curr;
        while (head1 != null || head2 != null) {
            if (head1 != null) {
                curr.next = head1;
                curr = curr.next;
                head1 = head1.next;
            }
            if (head2 != null) {
                curr.next = head2;
                curr = curr.next;
                head2 = head2.next;
            }
        }

        return temp.next;
    }

    private ListNode findMiddlePointOfLinkedList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null) {
            fast = fast.next;
            if (fast != null) {
                slow = slow.next;
                fast = fast.next;
            }
        }
        return slow;
    }

    public ListNode sortTwoAscendingSortedListInDescendingOrder(ListNode head1, ListNode head2) {
        ListNode temp1 = null;
        ListNode temp2;
        while (head1 != null || head2 != null) {
            if (head1 == null) {
                temp2 = head2.next;
                head2.next = temp1;
                temp1 = head2;
                head2 = temp2;
            } else if (head2 == null) {
                temp2 = head1.next;
                head1.next = temp1;
                temp1 = head1;
                head1 = temp2;
            } else {
                if (head1.data <= head2.data) {
                    temp2 = head1.next;
                    head1.next = temp1;
                    temp1 = head1;
                    head1 = temp2;
                } else {
                    temp2 = head2.next;
                    head2.next = temp1;
                    temp1 = head2;
                    head2 = temp2;
                }
            }
        }
        return temp1;
    }
}
