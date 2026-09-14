package 双指针;

import java.util.Scanner;

/**
 * @auther wty
 * @create 2026-03-31-10:45
 * @location HUBU
 * Description:字符串相加
 */
public class AddStrings {
    public static String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while(i >=0 || j >=0 || carry != 0){
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int sum = x + y + carry;
            int num = sum % 10;
            carry = sum / 10;
            sb.append(num);
            if(i >=0){
                i--;
            }
            if(j >= 0){
                j--;
            }
        }
        return sb.reverse().toString();
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String num1 = in.nextLine();
        String num2 = in.nextLine();
        String res = addStrings(num1,num2);
        System.out.println(res);
    }
}
