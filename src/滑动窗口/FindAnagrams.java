package 滑动窗口;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @auther wty
 * @create 2026-03-29-17:33
 * @location HUBU
 * Description:找到字符串中所有字母异位词
 */
public class FindAnagrams {

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int[] sArray = new int[26];
        int[] pArray = new int[26];
        for(int i = 0;i<p.length();i++){
            pArray[p.charAt(i) - 'a']++;
            sArray[s.charAt(i) - 'a']++;
        }
        if(Arrays.equals(sArray,pArray)){
            res.add(0);
        }
        for(int i = 0;i<s.length() - p.length();i++){
            sArray[s.charAt(i) - 'a']--;
            sArray[s.charAt(i+p.length()) - 'a']++;
            if(Arrays.equals(sArray,pArray)){
                res.add(i+1);
            }
        }
        return res;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String p = in.nextLine();
        List<Integer> res = findAnagrams(s,p);
        System.out.println(res);
    }
}
