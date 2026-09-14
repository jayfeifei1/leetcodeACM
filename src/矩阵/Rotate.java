package juzhen;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @auther wty
 * @create 2026-03-29-18:58
 * @location HUBU
 * Description:旋转图像
 */
public class Rotate {
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i = 0;i<n;i++){
            for(int j = i+1;j<n;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int i = 0;i<n;i++){
            int left = 0;
            int right = n-1;
            while(left < right){
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] matrix = new int[n][n];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                matrix[i][j] = in.nextInt();
            }
        }
        rotate(matrix);
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0;i<n;i++){
            List<Integer> path = new ArrayList<>();
            for(int j = 0;j<n;j++){
                path.add(matrix[i][j]);
            }
            res.add(path);
        }

        System.out.println(res);
    }
}
