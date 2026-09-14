package huisu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @auther wty
 * @create 2026-03-30-10:15
 * @location HUBU
 * Description:全排列
 */
public class Permute {
    static List<List<Integer>> res = new ArrayList<>();
    static List<Integer> path = new ArrayList<>();
    static boolean[] isUsed;
    public static List<List<Integer>> permute(int[] nums) {
        isUsed = new boolean[nums.length];
        backtracking(nums);
        return res;
    }
    public static void backtracking(int[] nums){
        if(path.size() == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = 0;i<nums.length;i++){
            if(isUsed[i]){
                continue;
            }
            isUsed[i] = true;
            path.add(nums[i]);
            backtracking(nums);
            path.remove(path.size() - 1);
            isUsed[i] = false;
        }
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for(int i = 0;i<n;i++){
            nums[i] = in.nextInt();
        }
        permute(nums);
        System.out.println(res);
    }
}
