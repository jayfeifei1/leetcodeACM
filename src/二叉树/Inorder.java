package 二叉树;

import java.util.*;

/**
 * @auther wty
 * @create 2026-03-29-20:10
 * @location HUBU
 * Description:二叉树的中序遍历
 */
public class Inorder {
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
    static List<Integer> res = new ArrayList<>();
    public static List<Integer> inorderTraversal(TreeNode root) {
        inorder(root);
        return res;
    }
    public static void inorder(TreeNode root){
        if(root == null){
            return;
        }
        inorder(root.left);
        res.add(root.val);
        inorder(root.right);
    }

    //传入字符串  构建二叉树
    public static TreeNode buildTree(String str){
        if(str == null || str.length() == 0){
            return null;
        }
        String[] strs = str.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(strs[0]));
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int i = 1;
        while(!queue.isEmpty() && i < strs.length){
            TreeNode node = queue.poll();
            if(i < strs.length && !strs[i].equals("null")){
                node.left = new TreeNode(Integer.parseInt(strs[i]));
                queue.offer(node.left);
            }
            i++;
            if(i < strs.length && !strs[i].equals("null")){
                node.right = new TreeNode(Integer.parseInt(strs[i]));
                queue.offer(node.right);
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        TreeNode root = buildTree(s);
        inorderTraversal(root);
        System.out.println(res);
    }
}
