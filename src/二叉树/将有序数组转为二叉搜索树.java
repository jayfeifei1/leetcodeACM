package 二叉树;

import java.util.List;

/**
 * @auther wty
 * @create 2026-09-23-21:38
 * @location HUBU
 * Description:
 */
public class 将有序数组转为二叉搜索树 {
    public static class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;
        TreeNode(int value){
            this.value = value;
        }
    }
    public static TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums,0,nums.length - 1);
    }
    public static TreeNode buildTree(int[] nums,int left,int right){
        if(left > right){
            return null;
        }
        int mid = left + (right - left)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildTree(nums,left,mid-1);
        root.right = buildTree(nums,mid + 1,right);
        return root;
    }

    public static void inorder(TreeNode root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.println(root.value + " ");
        inorder(root.right);

    }
    public static void main(String[] args) {
        int[] nums = new int[]{-10,-3,0,5,9};
        TreeNode root = sortedArrayToBST(nums);
        inorder(root);
    }
}
