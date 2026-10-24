package 链表;

/**
 * @auther wty
 * @create 2026-09-17-17:27
 * @location HUBU
 * Description:
 */
public class 随即链表的复制 {
    public static class Node{
        int val;
        Node random;
        Node next;
        Node(int val){
            this.val = val;

        }
    }
    public static Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        Node cur = head;
        while(cur != null){
            Node copyNode = new Node(cur.val);
            copyNode.next = cur.next;
            cur.next = copyNode;
            cur = cur.next.next;
        }
        cur = head;
        while(cur != null){
            Node copyNode = cur.next;
            if(cur.random == null){
                copyNode.random = null;
            }else{
                copyNode.random = cur.random.next;
            }
            cur = copyNode.next;
        }
        cur = head;
        Node newHead = cur.next;
        while(cur != null){
            Node copyNode = cur.next;
            Node nextOldNode = copyNode.next;
            if(nextOldNode == null){
                copyNode.next = null;
                cur.next = nextOldNode;
                cur = nextOldNode;
            }else{
                copyNode.next = nextOldNode.next;
                cur.next = nextOldNode;
                cur = nextOldNode;
            }
        }
        return newHead;
    }

    public static void main(String[] args) {
        Node node0 = new Node(7);
        Node node1 = new Node(13);
        Node node2 = new Node(11);
        Node node3 = new Node(10);
        Node node4 = new Node(1);
        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;
        node0.random = null;
        node1.random = node0;
        node2.random = node4;
        node3.random = node2;
        node4.random = node0;
        Node head = node0;
        Node newHead = copyRandomList(head);
        while(newHead != null){
            System.out.println(newHead.val + "  " + (newHead.random == null ? "null" : newHead.random.val));
            newHead = newHead.next;
        }


    }
}
