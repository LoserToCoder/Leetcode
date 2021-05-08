package com.leetcode.design;


import java.util.HashMap;
import java.util.Map;

/**
 * 设计思路:
 * 双向链表+Hash表
 */
public class LRUCache {

    class Node{

        int key;
        int val;
        Node next;
        Node prev;

        Node(int key,int val){
            this.key = key;
            this.val = val;
        }

    }


    private Map<Integer,Node>  map;

    private Node head;
    private Node tail;

    private int size;
    private int capacity;


    public LRUCache(int capacity) {
        this.capacity =capacity;
        this.size =0 ;
        this.map = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next =tail;
        tail.prev = head;
    }

    public int get(int key) {

        Node node = map.get(key);
        if(node==null){
            return -1;
        }
        int val = node.val;
        remove(key);
        addHead(key,val);
        return val;

    }

    public void put(int key, int value) {

        if(map.containsKey(key)){
            remove(key);
        }
        addHead(key,value);

    }

    /**
     * 双向链表
     * 添加需要 前处理前后两个节点的 prev,next 四个指针
     * @param key
     * @param val
     */
    private void addHead(int key,int val){

        Node node = new Node(key, val);

        Node next = head.next;

        head.next = node;
        node.prev = head;

        node.next = next;
        next.prev = node;
        size++;
        map.put(key, node);
        if(size>capacity) {
            Node prev = tail.prev;
            remove(prev.key);
        }

    }

    /**
     * 双向链表
     * 移除只需要关注前节点的next和后节点的prev两个指针
     * @param key
     */
    private void remove(int key){

        Node node = map.get(key);
        if(node==null){
            return;
        }
        Node next = node.next;
        Node prev = node.prev;
        prev.next = next;
        next.prev = prev;
        map.remove(key);
        size--;
    }


}
