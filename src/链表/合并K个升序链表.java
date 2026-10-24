package 链表;

import java.util.PriorityQueue;

/**
 * @auther wty
 * @create 2026-09-17-17:50
 * @location HUBU
 * Description:
 */
public class 合并K个升序链表 {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
        }
    }
    public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> a.val - b.val);
        for(ListNode list : lists){
            if(list != null){
                queue.offer(list);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while(!queue.isEmpty()){
            ListNode node = queue.poll();
            if(node.next != null){
                queue.offer(node.next);
            }
            cur.next = node;
            cur = node;

        }
        return dummy.next;
    }

    public static void main(String[] args) {
        // 第一条链表：1 -> 4 -> 5
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(4);
        ListNode a3 = new ListNode(5);

        a1.next = a2;
        a2.next = a3;

        // 第二条链表：1 -> 3 -> 4
        ListNode b1 = new ListNode(1);
        ListNode b2 = new ListNode(3);
        ListNode b3 = new ListNode(4);

        b1.next = b2;
        b2.next = b3;

        // 第三条链表：2 -> 6
        ListNode c1 = new ListNode(2);
        ListNode c2 = new ListNode(6);

        c1.next = c2;

        ListNode[] list = {a1,b1,c1};
        ListNode res = mergeKLists(list);
        while(res != null){
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
}
