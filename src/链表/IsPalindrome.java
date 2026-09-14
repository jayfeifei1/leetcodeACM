package lianbiao;

import java.util.List;
import java.util.Scanner;

/**
 * @auther wty
 * @create 2026-03-29-19:15
 * @location HUBU
 * Description:回文链表
 */
public class IsPalindrome {
    static class  ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){
            this.val = val;
        }
        ListNode(int val,ListNode next){
            this.val = val;
            this.next = next;
        }
    }

    public static boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode mid = slow.next;
        ListNode reverseNode = reverse(mid);
        ListNode left = head;
        ListNode right = reverseNode;
        boolean flag = true;
        while(flag && right != null){
            if(left.val != right.val){
                flag = false;
            }
            left = left.next;
            right = right.next;
        }
        reverse(reverseNode);
        return flag;
    }

    public static ListNode reverse(ListNode node){
        ListNode pre = null;
        ListNode cur = node;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] head = new int[n];
        for(int i = 0;i<n;i++){
            head[i] = in.nextInt();
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        for(int i = 0; i < n; i++){
            cur.next = new ListNode(head[i]);
            cur = cur.next;
        }

        System.out.println(isPalindrome(dummy.next));
    }
}
