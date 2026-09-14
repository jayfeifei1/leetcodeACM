package haxi;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @auther wty
 * @create 2026-03-29-16:38
 * @location HUBU
 * Description:两数之和
 */
public class TwoSum {
    public static  int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            int diff = target - nums[i];
            if(map.containsKey(diff)){
                return new int[]{map.get(diff),i};
            }
            map.put(nums[i],i);
        }
        return new int[0];
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);//创建输入对象
        int n = in.nextInt();//读取数据   nums的个数
        int target = in.nextInt();//读取数据  目标值
        int[] nums = new int[n];
        for(int i = 0;i<n;i++){//循环读取数据
            nums[i] = in.nextInt();//每次读一个整数
        }
        int[] res = twoSum(nums,target);
        for(int i : res){
            System.out.print(i + " ");
        }
    }
}
