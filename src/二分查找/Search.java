package erfenchazhao;

import java.util.Scanner;

/**
 * @auther wty
 * @create 2026-03-30-10:06
 * @location HUBU
 * Description:搜索旋转排序数组
 */
public class Search {

    public static int search(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[left] <= nums[mid]){
                if(nums[left] <= target && target < nums[mid]){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }else{
                if(target > nums[mid] && target <= nums[right]){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for(int i = 0;i<n;i++){
            nums[i] = in.nextInt();
        }
        int target = in.nextInt();
        System.out.println(search(nums,target));
    }
}
