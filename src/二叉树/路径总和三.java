package 二叉树;

import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * @auther wty
 * @create 2026-09-24-8:53
 * @location HUBU
 * Description:
 */
public class 路径总和三 {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }
    static long prefix;
    static int res = 0;
    static Map<Long,Integer> map = new HashMap<>();
    public static int pathSum(TreeNode root, int targetSum) {
        map.put(0l,1);
        prefix = 0;
        backtracking(root,targetSum);
        return res;
    }
    public static void backtracking(TreeNode root,int targetSum){
        if(root == null){
            return;
        }
        prefix += root.val;
        res += map.getOrDefault( (prefix - targetSum),0);
        map.put(prefix,map.getOrDefault(prefix,0) + 1);
        backtracking(root.left,targetSum);
        backtracking(root.right,targetSum);
        map.put(prefix,map.getOrDefault(prefix,0) - 1);
        prefix -= root.val;
    }
    public static TreeNode buildTree(String strs){
        if(strs == null || strs.length() == 0){
            return null;
        }
        String[] str = strs.split(" ");
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

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int targetSum = 8;
        TreeNode root = buildTree(str);
        System.out.println(pathSum(root,targetSum));
    }
}
