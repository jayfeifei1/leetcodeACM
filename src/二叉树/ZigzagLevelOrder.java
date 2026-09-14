package 二叉树;

import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * @auther wty
 * @create 2026-03-30-11:16
 * @location HUBU
 * Description:
 */
public class ZigzagLevelOrder {
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
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        boolean isLeftToRight = true;
        while(!queue.isEmpty()){
            int size = queue.size();
            Deque<Integer> path = new ArrayDeque<>();
            for(int i = 0;i<size;i++){
                TreeNode node = queue.poll();
                if(isLeftToRight){
                    path.offerLast(node.val);
                }else{
                    path.offerFirst(node.val);
                }
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
            isLeftToRight = !isLeftToRight;
            res.add(new ArrayList<>(path));
        }
        return res;
    }
    public static TreeNode buildTree(String s){
        if(s == null || s.length() == 0){
            return null;
        }
        String[] str = s.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(str[0]));
        int index = 1;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
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
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        TreeNode root = buildTree(s);
        List<List<Integer>> res = zigzagLevelOrder(root);
        System.out.println(res);
    }

}
