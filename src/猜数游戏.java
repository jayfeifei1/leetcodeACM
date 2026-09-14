import java.util.Random;
import java.util.Scanner;

/**
 * @auther wty
 * @create 2026-09-14-8:49
 * @location HUBU
 * Description:
 */
public class 猜数游戏 {
    public static void main(String[] args) {
        Random rand = new Random();
        int randNumber = rand.nextInt(100) + 1;
        Scanner in = new Scanner(System.in);
        System.out.println("请输入您的猜测：");
        while (true) {
            if(!in.hasNextInt()){
                System.out.println("输入有误，请输入整数");
                in.next();
                continue;
            }
            int guess = in.nextInt();
            if(guess < randNumber){
                System.out.println("小了");
            }else if(guess > randNumber){
                System.out.println("大了");
            }else{
                System.out.println("对了");
                break;
            }
        }
    }
}
