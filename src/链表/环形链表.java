package 链表;

import java.util.Scanner;

/**
 * @auther wty
 * @create 2026-09-14-19:26
 * @location HUBU
 * Description:
 */
public class 环形链表 {
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
    public static boolean hasCycle(ListNode head){
        if(head == null || head.next == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }
    public static ListNode buildList(int[] nums,int pos){
        if(nums == null || nums.length == 0){
            return null;
        }
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        ListNode cycleNode = null;
        for(int i = 0;i<nums.length;i++){
            cur.next = new ListNode(nums[i]);
            cur = cur.next;
            if(pos == i){
                cycleNode = cur;
            }
            if(pos != -1){
                cur.next = cycleNode;
            }
        }
        return dummy.next;

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for(int i = 0;i < nums.length;i++){
            nums[i] = in.nextInt();
        }
        int pos = in.nextInt();
        ListNode head = buildList(nums,pos);
        System.out.println(hasCycle(head));
    }
}
