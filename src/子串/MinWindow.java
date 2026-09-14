package 子串;

import java.util.HashMap;
import java.util.Map;
import java.util.*;
/**
 * @auther wty
 * @create 2026-03-29-17:52
 * @location HUBU
 * Description:最小覆盖子串
 */
public class MinWindow {

    public static String minWindow(String s, String t) {
        if(s == null || s.length() < t.length()){
            return "";
        }
        Map<Character,Integer> mapNeed = new HashMap<>();
        Map<Character,Integer> mapHave = new HashMap<>();
        for(int i = 0;i<t.length();i++){
            char c = t.charAt(i);
            mapNeed.put(c,mapNeed.getOrDefault(c,0) + 1);
        }
        int needTypes = mapNeed.size();
        int haveTypes = 0;
        int start = 0;
        int left = 0;
        int minLength = Integer.MAX_VALUE;
        for(int right = 0;right<s.length();right++){
            char c = s.charAt(right);
            if(mapNeed.containsKey(c)){
                mapHave.put(c,mapHave.getOrDefault(c,0) + 1);
                if(mapNeed.get(c) == mapHave.get(c)){
                    haveTypes++;
                }
                while(haveTypes == needTypes){
                    if(right - left + 1< minLength){
                        minLength = right - left + 1;
                        start = left;
                    }
                    char d = s.charAt(left);
                    left++;
                    if(mapNeed.containsKey(d)){
                        mapHave.put(d,mapHave.get(d) - 1);
                        if(mapHave.get(d) < mapNeed.get(d)){
                            haveTypes--;
                        }
                    }
                }
            }
        }
        if(minLength == Integer.MAX_VALUE){
            return "";
        }
        return s.substring(start,start+minLength);
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String t = in.nextLine();
        System.out.print(minWindow(s,t));
    }
}
