package 数组;

import java.util.Scanner;

/**
 * @auther wty
 * @create 2026-09-14-18:48
 * @location HUBU
 * Description:
 */
public class 缺失的第一个正数 {
    public static int missFirst(int[] nums){
        int n = nums.length;
        for(int i = 0;i < n;i++){
            while(nums[i] >=1 && nums[i] <=n){
                int rightIndex = nums[i] - 1;
                if(nums[i] == nums[rightIndex]){
                    break;
                }
                int temp = nums[i];
                nums[i] = nums[rightIndex];
                nums[rightIndex] = temp;
            }
        }
        for(int i = 0;i<n;i++){
            if(nums[i] != i+1){
                return i+1;
            }
        }
        return n+1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums=new int[n];
        for(int i = 0;i < n;i++){
            nums[i] = in.nextInt();
        }
        System.out.println(missFirst(nums));
    }
}
