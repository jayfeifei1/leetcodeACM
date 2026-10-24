package 二叉树;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @auther wty
 * @create 2026-09-24-15:01
 * @location HUBU
 * Description:
 */
public class 二叉树的最近公共祖先 {
    public static class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;
        TreeNode(int value){
            this.value = value;
        }
    }
    public static TreeNode lowestCommonAncestor(TreeNode root,TreeNode p,TreeNode q){
        if(root == null){
            return null;
        }
        if(root == p || root == q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left != null && right != null){
            return root;
        }
        if(left != null){
            return left;
        }
        if(right != null){
            return right;
        }
        return null;
    }
    //建树
    public static TreeNode buildTree(String strs){
        if(strs == null || strs.length() == 0){
            return null;
        }
        String[] str = strs.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(str[0]));
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int index = 1;
        while(!queue.isEmpty() && index < str.length){
            TreeNode node = queue.poll();
            if(index < str.length && !str[index].equals("null")){
                node.left = new TreeNode(Integer.parseInt(str[index]));
                queue.offer(node.left);
            }
            index++;
            if(index < str.length && !str[index].equals("null")){
                node.right = new TreeNode(Integer.parseInt(str[index]));
                queue.offer(node.right);
            }
            index++;
        }
        return root;
    }
    //根据值 找到对应树中的树节点
    public static TreeNode getNode(TreeNode root,int val){
        if(root == null){
            return null;
        }
        if(root.value == val){
            return root;
        }
        TreeNode left = getNode(root.left,val);
        if(left != null){
            return left;
        }
        return getNode(root.right,val);
    }

    public static void main(String[] args) {
        String strs = "3,5,1,6,2,0,8,null,null,7,4";
        TreeNode root = buildTree(strs);
        TreeNode p = getNode(root,5);
        TreeNode q = getNode(root,1);
        TreeNode res = lowestCommonAncestor(root,p,q);
        if(res == null){
            System.out.println("null");
        }else{
            System.out.println(res.value);
        }

    }
}
