package com.hp.controller;

import com.hp.service.CustomerService;
import com.hp.util.TestUtil;

import java.util.Scanner;

public class Main {
    private static String cardNum;
    private static String cardPwd;
    private static CustomerService customerService;
    public static void main(String[] args) {
        customerService= new CustomerService();
        //欢迎界面
        TestUtil.welcome();
        //输入账户密码
        int i=0;
        while(i<6) {
            doWritePwd();
            //校验角色及账户密码的正确性
            doCheckPwd(cardNum,cardPwd);
            i++;
        }
    }

    private static void doWritePwd() {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入账号");
        cardNum= sc.nextLine();
        System.out.println("cardNum = " + cardNum);
        System.out.println("请输入密码");
        cardPwd=sc.nextLine();
        System.out.println("cardPwd = " + cardPwd);
    }
    private static void doCheckPwd(String cardNum,String cardPwd){
        if(cardNum.length()==8){//客户
            customerService.checkPwd(cardNum,cardPwd);
        }
    }

}
