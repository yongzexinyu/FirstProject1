import java.util.Scanner;

public class Factorial {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入一个数字");
        int num= sc.nextInt();
        System.out.println(testFactorial(num));
    }
    public static int testFactorial(int num){
        if(num<=1){
            return 1;
        }
            return  num*(num-1);
    }
}
