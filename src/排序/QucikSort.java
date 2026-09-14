package 排序;

import java.util.Random;
import java.util.*;
/**
 * @auther wty
 * @create 2026-03-30-9:45
 * @location HUBU
 * Description:经典快速排序
 */
public class QucikSort {
    static Random rand = new Random();
    public static int[] sortArray(int[] nums) {
        quicksort(nums,0,nums.length-1);
        return nums;
    }
    public static void quicksort(int[] nums,int left,int right){
        if(left >= right){
            return;
        }
        int pivotIndex = partition(nums,left,right);
        quicksort(nums,left,pivotIndex-1);
        quicksort(nums,pivotIndex+1,right);
    }
    public static int partition(int[] nums,int left,int right){
        int pivotIndex = left + rand.nextInt(right - left + 1);
        int pivot = nums[pivotIndex];
        swap(nums,left,pivotIndex);
        int i = left + 1;
        int j = right;
        while(true){
            while(i <= j && nums[i] < pivot){
                i++;
            }
            while(i <= j && nums[j] > pivot){
                j--;
            }
            if(i >= j){
                break;
            }
            swap(nums,i,j);
        }
        swap(nums,left,j);
        return j;
    }
    public static void swap(int[] nums,int left,int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for(int i = 0;i<n;i++){
            nums[i] = in.nextInt();
        }
        sortArray(nums);
        for(int num : nums){
            System.out.print(num + " ");
        }
    }
}
