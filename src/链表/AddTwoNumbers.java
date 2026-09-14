package 链表;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @auther wty
 * @create 2026-04-02-15:11
 * @location HUBU
 * Description:
 */
public class AddTwoNumbers {
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
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while(l1 != null || l2 != null || carry != 0){
            int x = l1 != null ? l1.val : 0;
            int y = l2 != null ? l2.val : 0;
            int sum = x + y + carry;
            int num = sum % 10;
            carry = sum / 10;
            cur.next = new ListNode(num);
            cur = cur.next;
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
        }
        return dummy.next;
    }
    public static ListNode build(int[] nums){
        if(nums == null || nums.length == 0){
            return null;
        }
        ListNode dummy = new ListNode(-1);
        ListNode cur  = dummy;
        for(int i = 0;i<nums.length;i++){
            cur.next = new ListNode(nums[i]);
            cur = cur.next;
        }
        return dummy.next;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n1 = in.nextInt();
        int[] l1 = new int[n1];
        for(int i = 0;i<n1;i++){
            l1[i] = in.nextInt();
        }
        int n2 = in.nextInt();
        int[] l2 = new int[n2];
        for(int i = 0;i<n2;i++){
            l2[i] = in.nextInt();
        }
        ListNode list1 = build(l1);
        ListNode list2 = build(l2);
        ListNode resNode = addTwoNumbers(list1,list2);
        List<Integer> res = new ArrayList<>();
        ListNode cur = resNode;
        while(cur != null){
            res.add(cur.val);
            cur = cur.next;
        }
        System.out.println(res);

    }
}
