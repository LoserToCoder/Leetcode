package com.leetcode.tree;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
class Pair{
    private TreeNode curNode;
    private boolean isBacktrack;
    public Pair(TreeNode node, boolean isBacktrack){
        this.isBacktrack=isBacktrack;
        this.curNode=node;
    }

    public boolean isBacktrack() {
        return isBacktrack;
    }

    public TreeNode getCurNode() {
        return curNode;
    }

    public Pair setBacktrack() {
        isBacktrack =!isBacktrack;
        return this;
    }
}
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){this.val=val;}
}
public class PostOrderTraversal {

    public List<Integer> postorderTraversalByRecursion(TreeNode root) {
        List<Integer> traversal = new ArrayList<>();
        recursion(traversal,root);
        return traversal;
    }

    /***
     * 递归方式实现二叉树的后序
     * @param traversal
     * @param node
     */
    public void recursion(List<Integer> traversal,TreeNode node) {
        if (node != null) {
            recursion(traversal,node.left);
            recursion(traversal,node.right);
            traversal.add(node.val);
        }
    }

    /***
     * 迭代方式实现二叉树的后序
     * @param root
     * @return
     *
     * 常规的遍历方式基本上是很繁琐去解决问题
     * 可以考虑次序来解决问题
     */
    public List<Integer> postorderTraversal(TreeNode root) {

        LinkedList<Integer> traversal = new LinkedList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        if(root==null){
            return traversal;
        }
        stack.add(root);
        while (!stack.isEmpty()) {

            TreeNode node=stack.pollLast();
            traversal.addFirst(node.val);
            if(node.left!=null){
                stack.add(node.left);
            }
            if(node.right!=null){
                stack.add(node.right);
            }
        }
        return traversal;
    }

    /**
     * 关键点在于,右子节点和其父节点顺序的问题,
     * 后序遍历右子节点在其父节点之前,所有需要引入一个
     * 辅助变量来代表其右子节点是否已经访问过
     * @param root
     * @return
     */
    public static List<Integer> postOrder(TreeNode root){
        Stack<Pair> stack=new Stack<>();
        List<Integer> traversal = new ArrayList<>();
        TreeNode cur=root;
        while (cur!=null||!stack.isEmpty()){

            if(cur!=null){
                stack.push(new Pair(cur,false));
                cur=cur.left;
            }else {
                Pair pair=stack.pop();
                cur=pair.getCurNode();
                /**
                 当一个节点的右节点为null时,说明到该节点访问结束,继续回退,
                 或者该节点的右节点不为null,并且已经访问过了,此时也要回退*/
                if(cur.right==null||pair.isBacktrack()){
                    traversal.add(cur.val);
                    cur=null;
                    continue;
                }
                /**
                 此时右节点不为null时候,cur节点要等要右节点结束才能,这时候需要设置可以回退,
                 以为这下次再出现该节点时,直接判断isBacktrack,就可以知道该节点的右节点是否已经访问过了。
                 */
                if(cur.right!=null){
                    stack.push(pair.setBacktrack());
                    cur=cur.right;
                }
            }
        }
        return traversal;

    }
    public static void main(String[] args) {
           //[10,7,13,3,8,12,14,null,5,null,null,null,null,null,null,4,6]
        System.out.println(postOrder(null));
    }
    
}
