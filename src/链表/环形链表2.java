package 链表;

import java.util.Scanner;

/**
 * @auther wty
 * @create 2026-09-14-19:51
 * @location HUBU
 * Description:
 */
public class 环形链表2 {
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
        }
        ListNode(int val,ListNode next){
            this.val = val;
            this.next = next;
        }
    }
    public static ListNode buildList(int[] nums,int pos){
        if(nums == null || nums.length == 0){
            return null;
        }
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        ListNode cycleNode = null;
        for(int i = 0;i < nums.length;i++){
            cur.next = new ListNode(nums[i]);
            cur = cur.next;
            if(pos == i){
                cycleNode = cur;
            }
        }
        if(pos != -1){
            cur.next = cycleNode;
        }
        return dummy.next;
    }
    public static ListNode cycleList2(ListNode head){
        if(head == null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                ListNode headA = slow;
                ListNode headB = head;
                while(headA != headB){
                    headA = headA.next;
                    headB = headB.next;
                }
                return headA;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for(int i = 0;i < n;i++){
            nums[i] = in.nextInt();
        }
        int pos = in.nextInt();
        ListNode head = buildList(nums,pos);
        ListNode resNode = cycleList2(head);
        if(resNode!= null){
            System.out.println("返回索引为"+(resNode.val - 1) + "的链表节点");
        }else{
            System.out.println("返回NULL");
        }
    }
}
