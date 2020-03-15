package com.leetcode.stack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
public class BoardFirstSearch {

    public List<List<Integer>> levelOrder(Node root) {

        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> nodes = null;
        LinkedList<Node> queue = new LinkedList<>();
        if(root!=null){
            queue.addFirst(root);
            nodes = new ArrayList<>();
            nodes.add(root.val);
            lists.add(nodes);
        }
        while (!queue.isEmpty()){
            Node node = queue.pollFirst();
            if(node.children!=null&&node.children.size()>1){
                nodes = new ArrayList<>();
                for(Node n:node.children){
                    queue.addLast(n);
                    nodes.add(n.val);
                }
                lists.add(nodes);
            }
        }
        return lists;
    }


}
