package 双指针;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @auther wty
 * @create 2026-09-13-19:14
 * @location HUBU
 * Description:
 */
public class 三数之和 {
    public static List<List<Integer>> threeNumsSum(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0;i < nums.length;i++){
            if(i >=1 && nums[i] == nums[i - 1]){
                continue;
            }
            if(nums[i] > 0){
                break;
            }
            int left = i +1;
            int right = nums.length - 1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                List<Integer> list = new ArrayList<>();
                if(sum == 0){
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    res.add(list);
                    while(left < right && nums[left] == nums[left + 1]){
                        left++;
                    }
                    while(left < right && nums[right] == nums[right - 1]){
                        right--;
                    }
                    left++;
                    right--;
                }else if(sum < 0){
                    left++;
                }else{
                    right--;
                }
            }
        }
        return res;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for(int i = 0;i<n;i++){
            nums[i] = in.nextInt();
        }
        List<List<Integer>> res = threeNumsSum(nums);
        System.out.println(res);
    }
}
