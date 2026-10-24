package 链表;

import java.util.HashMap;

/**
 * @auther wty
 * @create 2026-09-17-17:56
 * @location HUBU
 * Description:
 */
public class LRU缓存 {
    public class Node{
        int key;
        int value;
        Node pre;
        Node next;
        Node(int key,int value){
            this.key = key;
            this.value = value;
        }
    }
    HashMap<Integer,Node> map = new HashMap<>();
    Node dummyTail;
    Node dummyPre;
    int capacity;
    public void LRUCache(int capacity){
        this.capacity = capacity;
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
        return node.value;
    }
    public void put(int key,int value){
        Node node = map.get(key);
        if(node != null){
            node.value = value;
            moveToHead(node);
        }
        node = new Node(key,value);
        map.put(key,node);
        addToHead(node);
        if(map.size() > capacity){
            Node deleteNode = dummyTail.pre;
            map.remove(deleteNode.key);
            removeNode(deleteNode);
        }
    }
    public void removeNode(Node node){
        Node preNode = node.pre;
        Node nextNode = node.next;
        preNode.next = nextNode;
        nextNode.pre = preNode;
        node.pre = null;
        node.next = null;
    }
    public void addToHead(Node node){
        Node firstNode = dummyPre.next;
        node.next = firstNode;
        firstNode.pre = node;
        dummyPre.next = node;
        node.pre = dummyPre;
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
    }
}
