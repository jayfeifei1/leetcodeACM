package 二叉树;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @auther wty
 * @create 2026-04-02-16:05
 * @location HUBU
 * Description:二叉树中的最大路径和
 */
public class MaxPathSum {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val){
            this.val = val;
        }
        TreeNode(int val,TreeNode left,TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    static int res = Integer.MIN_VALUE;
    public static int maxPathSum(TreeNode root) {

        dfs(root);
        return res;
    }
    public static int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = Math.max(dfs(root.left),0);
        int right = Math.max(dfs(root.right),0);
        res  = Math.max(res,left + right + root.val);
        return Math.max(left,right) + root.val;
    }
    public static TreeNode buildTree(String str){
        if(str == null || str.length() == 0){
            return null;
        }
        String[] strs = str.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(strs[0]));
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int index = 1;
        while(index < strs.length && !queue.isEmpty()){
            TreeNode node = queue.poll();
            if(index < strs.length && !strs[index].equals("null")){
                node.left = new TreeNode(Integer.parseInt(strs[index]));
                queue.offer(node.left);
            }
            index++;
            if(index < strs.length && !strs[index].equals("null")){
                node.right = new TreeNode(Integer.parseInt(strs[index]));
                queue.offer(node.right);
            }
            index++;
        }
        return root;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        TreeNode root = buildTree(str);
        maxPathSum(root);
        System.out.println(res);
    }
}
