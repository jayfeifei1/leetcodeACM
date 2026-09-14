package 链表;

import java.util.HashMap;
import java.util.Map;

/**
 * @auther wty
 * @create 2026-09-14-20:53
 * @location HUBU
 * Description:
 */
public class LRUCache {
    class Node{
        int key;
        int val;
        Node next;
        Node pre;
        Node(int key,int val){
            this.key = key;
            this.val = val;
        }
        Node(int key,int value,Node next,Node pre) {
            this.key = key;
            this.val = val;
            this.next = next;
            this.pre = pre;
        }
    }
    int capatity;
    Map<Integer,Node> map = new HashMap<>();
    Node dummyPre;
    Node dummyTail;
    public LRUCache(int capatity){
        this.capatity = capatity;
        dummyPre = new Node(-1,-1);
        dummyTail = new Node(-1,-1);
        dummyPre.next = dummyTail;
        dummyTail.pre = dummyPre;
    }
    public int get(int key){
        Node node = map.get(key);
        if(node == null){
            return -1;
        }
        moveToHead(node);
        return node.val;
    }
    public void put(int key,int value){
        Node node = map.get(key);
        if(node != null){
            node.val = value;
            moveToHead(node);
            return;
        }
        node = new Node(key,value);
        addToHead(node);
        map.put(key,node);
        if(map.size() > capatity){
            Node deleteNode = dummyTail.pre;
            removeNode(deleteNode);
            map.remove(deleteNode.key);
        }
    }
    public void removeNode(Node node){
        Node pre = node.pre;
        Node next = node.next;
        pre.next = next;
        next.pre = pre;
        node.pre = null;
        node.next = null;
    }
    public void addToHead(Node node){
        Node firstNode = dummyPre.next;
        dummyPre.next = node;
        node.pre = dummyPre;
        node.next = firstNode;
        firstNode.pre = node;
    }
    public void moveToHead(Node node){
        removeNode(node);
        addToHead(node);
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1,1);
        lruCache.put(2,2);
        System.out.println(lruCache.get(1));

        lruCache.put(3,3);
        System.out.println(lruCache.get(2));

        lruCache.put(4,4);
        System.out.println( lruCache.get(1));
        System.out.println(  lruCache.get(3));
        System.out.println(lruCache.get(4));

    }

}
