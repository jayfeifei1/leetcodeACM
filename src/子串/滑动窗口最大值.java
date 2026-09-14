package 子串;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * @auther wty
 * @create 2026-09-13-16:35
 * @location HUBU
 * Description:
 */
public class 滑动窗口最大值 {
    public static int[] maxSlideingWindow(int[] nums,int k){
        int n = nums.length;
        int[] res = new int[n - k + 1];
        int index = 0;
        Deque<Integer> queue= new ArrayDeque<>();
        for(int i = 0;i < n;i++){
            if(!queue.isEmpty() && queue.peekFirst() < i - k + 1){
                queue.pollFirst();
            }
            while(!queue.isEmpty() && nums[queue.peekLast()] < nums[i]){
                queue.pollLast();
            }
            queue.offerLast(i);
            if(i - k + 1 >=0){
                res[index++] = nums[queue.peekFirst()];
            }
        }
        return res;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for(int i = 0;i < n;i++){
            nums[i] = in.nextInt();
        }
        int k = in.nextInt();
        int[] res = maxSlideingWindow(nums,k);
        for (int i : res){
            System.out.print(i + " ");
        }
    }
}
