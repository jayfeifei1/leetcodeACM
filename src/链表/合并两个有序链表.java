package 链表;

import java.util.Scanner;

/**
 * @auther wty
 * @create 2026-09-14-20:26
 * @location HUBU
 * Description:
 */
public class 合并两个有序链表 {
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

    static public ListNode buildList(int[] nums){
        if(nums == null || nums.length == 0){
            return null;
        }
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        for(int i = 0;i < nums.length;i++){
            cur.next = new ListNode(nums[i]);
            cur = cur.next;
        }
        return dummy.next;
    }
    public static ListNode mergeTwoList(ListNode l1,ListNode l2){
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;
            }else{
                cur.next = l2;
                cur = cur.next;
                l2 = l2.next;
            }
        }
        cur.next = l1 != null ? l1: l2;
        return dummy.next;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n1 = in.nextInt();
        int[] nums1 = new int[n1];
        for(int i = 0;i<n1;i++){
            nums1[i] = in.nextInt();
        }
        int n2 = in.nextInt();
        int[] nums2 = new int[n2];
        for(int i = 0;i<n2;i++){
            nums2[i] = in.nextInt();
        }
        ListNode l1 = buildList(nums1);
        ListNode l2 = buildList(nums2);
        ListNode resNode = mergeTwoList(l1,l2);
        while(resNode != null){
            System.out.print(resNode.val + " ");
            resNode = resNode.next;
        }

    }
}
