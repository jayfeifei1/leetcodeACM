package 二叉树;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * @auther wty
 * @create 2026-09-14-21:44
 * @location HUBU
 * Description:
 */
public class 二叉树的最大深度 {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }
    public static int maxDeep(TreeNode root){
        return postOrder(root);
    }
    public static int postOrder(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = postOrder(root.left);
        int right = postOrder(root.right);
        return Math.max(left,right) + 1;
    }
    public static TreeNode buildTree(String s){
        if(s == null || s.length() == 0){
            return null;
        }
        String[] str = s.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(str[0]));
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int index = 1;
        while(!queue.isEmpty() && index < str.length){
            TreeNode rootNode = queue.poll();
            if(index < str.length && !str[index].equals("null")){
                rootNode.left = new TreeNode(Integer.parseInt(str[index]));
                queue.offer(rootNode.left);
            }
            index++;
            if(index < str.length && !str[index].equals("null")){
                rootNode.right = new TreeNode(Integer.parseInt(str[index]));
                queue.offer(rootNode.right);
            }
            index++;
        }
        return root;

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        TreeNode root = buildTree(s);
        int deep = maxDeep(root);
        System.out.println(deep);
    }
}
