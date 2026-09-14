import java.util.Scanner;

/**
 * @auther wty
 * @create 2026-09-14-13:59
 * @location HUBU
 * Description:
 */
public class 字符串相加 {
    public static String addStrings(String num1,String num2){
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        while(i>=0 || j >=0 || carry !=0){
            int a = (i>=0)?num1.charAt(i) - '0' : 0;
            int b = (j>=0)?num2.charAt(j) - '0' : 0;
            int sum = a + b + carry;
            int num = sum % 10;
            carry = sum /10;
            sb.append(num);
            if(i>=0){
                i--;
            }
            if(j>=0){
                j--;
            }
        }
        return sb.reverse().toString();
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String num1 = in.nextLine();
        String num2 = in.nextLine();
        String s = addStrings(num1,num2);
        System.out.println(s);
    }
}
