package com.hp.util;
public class TestUtil {
    public static void welcome(){
        System.out.println("****************");
        System.out.println("先生/女士");
        System.out.println("欢迎使用ATM取款机");
        System.out.println("****************");
    }
    public static void  oneOption(){
        System.out.println("********************");
        System.out.println("**1.查询余额，2.取款 3.存款 4.转账 5.退出*******");
        System.out.println("*********************");
    }
    public static void  getMoneyUI(){
        System.out.println("********************");
        System.out.println("******请输入你的取款金额：*************");
        System.out.println("*****1.100         2.200 ***************");
        System.out.println("*****3.300         4.500 ***************");
        System.out.println("************5.其他***********************");
        System.out.println("********************");
    }
}
