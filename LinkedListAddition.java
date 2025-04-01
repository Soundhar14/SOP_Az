import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

public class LinkedListAddition {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0); 
        ListNode current = dummyHead;
        int carry = 0; 

        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum / 10;
            current.next = new ListNode(sum % 10); 
            current = current.next;
        }

        return dummyHead.next;  
    }
    
    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }
    
    public static ListNode createList(Scanner scanner) {

        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;

        while (true) {
            int num = scanner.nextInt();
            if (num == -1) break;
            current.next = new ListNode(num);
            current = current.next;
        }

        return dummyHead.next; 
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the first number as a linked list:");
        ListNode l1 = createList(scanner);

        System.out.println("Enter the second number as a linked list:");
        ListNode l2 = createList(scanner);

        LinkedListAddition solution = new LinkedListAddition();
        ListNode result = solution.addTwoNumbers(l1, l2);

        System.out.println("Sum as a linked list:");
        printList(result);

        scanner.close();
    }
}