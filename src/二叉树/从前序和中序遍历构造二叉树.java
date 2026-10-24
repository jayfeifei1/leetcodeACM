package 二叉树;

import java.util.*;

/**
 * @auther wty
 * @create 2026-09-24-8:22
 * @location HUBU
 * Description:
 */
public class 从前序和中序遍历构造二叉树 {
    public static class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;
        TreeNode(int value){
            this.value = value;
        }
    }
    static Map<Integer,Integer> map = new HashMap<>();

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0;i < inorder.length;i++){
            map.put(inorder[i],i);
        }
        return build(preorder,0,preorder.length-1,inorder,0,inorder.length - 1);
    }
    public static TreeNode build(int[] preorder,int preLeft,int preRight,int[] inorder,int inLeft,int inRight){
        if(preLeft > preRight){
            return null;
        }
        int rootValue = preorder[preLeft];
        TreeNode root = new TreeNode(rootValue);
        int rootIndexInorder = map.get(rootValue);
        int leftLength = rootIndexInorder - inLeft;
        root.left = build(preorder,preLeft+1,preLeft+leftLength,inorder,inLeft,rootIndexInorder-1);
        root.right = build(preorder,preLeft+1+leftLength,preRight,inorder,rootIndexInorder+1,inRight);
        return root;

    }
    public static List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> path = new ArrayList<>();
            for(int i = 0;i < size;i++){
                TreeNode node = queue.poll();
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
                path.add(node.value);
            }
            res.add(path);
        }
        return res;
    }

    public static void main(String[] args){
        int[] preorder = new int[]{3,9,20,15,7};
        int[] inorder = new int[]{9,3,15,20,7};
        TreeNode root = buildTree(preorder,inorder);
        List<List<Integer>> res = levelOrder(root);
        System.out.println(res);
    }
}
