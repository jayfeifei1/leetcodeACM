package 链表;

import java.util.Scanner;

/**
 * @auther wty
 * @create 2026-03-30-10:30
 * @location HUBU
 * Description:
 */
public class ReverseBetween {
    static class ListNode{
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
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        for(int i = 0;i<left - 1;i++){
            pre = pre.next;
        }
        ListNode leftNode = pre.next;
        ListNode rightNode = pre;
        for(int i = 0;i<right - left + 1;i++){
            rightNode = rightNode.next;
        }
        ListNode rightNextNode = rightNode.next;
        pre.next = null;
        rightNode.next = null;
        reverseNode(leftNode);
        pre.next = rightNode;
        leftNode.next = rightNextNode;
        return dummy.next;
    }
    public static ListNode reverseNode(ListNode node){
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
    public static ListNode build(int[] head){
        if(head == null || head.length == 0){
            return null;
        }
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        for(int i = 0;i<head.length;i++){
            cur.next = new ListNode(head[i]);
            cur = cur.next;
        }
        return dummy.next;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] head = new int[n];
        for(int i = 0;i<n;i++){
            head[i] = in.nextInt();
        }
        ListNode node = build(head);
        int left = in.nextInt();
        int right = in.nextInt();
        ListNode resNode = reverseBetween(node,left,right);
        while(resNode != null){
            System.out.print(resNode.val + " ");
            resNode = resNode.next;
        }
    }
}
