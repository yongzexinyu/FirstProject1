package com.hp.service;

import com.hp.bean.Customer;
import com.hp.bean.CustomerData;
import com.hp.util.TestUtil;

import java.util.List;
import java.util.Scanner;

public class CustomerService {
    private static Customer currentCustomer;
    private static boolean flag;
    private List<Customer> customers;
    private static Double s;


    public void checkPwd(String cardNum,String cardPwd){
        CustomerData cus= CustomerData.getInstance();
        customers= cus.getList();
        System.out.println("cardNum = " + cardNum);
        System.out.println("cardPwd = " + cardPwd);
        for (Customer c:customers) {
            if(c.getAccount().equals(cardNum) && c.getPwd().equals(cardPwd)){
                currentCustomer=c;
                System.out.println("欢迎"+c.getCname()+"用户，请注意安全");
                TestUtil.oneOption();
                Scanner sc=new Scanner(System.in);
                Integer option = sc.nextInt();
                choose(option);
            }

        }
    }

    private void choose(Integer option) {
            if(option>=6){
                truanWright();
            }
        switch (option){
            case 1:
                System.out.println("查询余额");
                doSelectMoney();
                goHome();
                break;
            case 2:
                System.out.println("取款");
                withdrawMoney();
                goHome();
                break;
            case 3:
                System.out.println("存款");
                deposit();
                goHome();
                break;
            case 4:
                System.out.println("转账");
                doTruanMoney();
                goHome();
                break;
            case 5:
                System.out.println("退出");
                TestUtil.welcome();
                System.exit(0);
                goHome();
                break;
        }
    }

    private void doTruanMoney() {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入对方账号");
        String otherAcount= sc.nextLine();
        System.out.println("请输入转账金额");
        Double otherMoney=sc.nextDouble();
        Double money=currentCustomer.getMoney()-otherMoney;
        if(money<0){
            System.out.println("余额不足，转账失败");
        }else{
            Customer other=null;
            for (Customer c:customers){
                if(c.getAccount().equals(otherAcount)){
                    other=c;

                }
            }
            double v = other.getMoney() + otherMoney;
            other.setMoney(v);
            currentCustomer.setMoney(money);
        }
    }


    private void deposit() {
        Scanner sc=new Scanner(System.in);
        System.out.println("请选择你要存款的金额1.200 2.500 3.1000");
        double money1 = sc.nextDouble();

        if (money1 %100==0 ) {
            double depositMoney=currentCustomer.getMoney()+money1;
            currentCustomer.setMoney(depositMoney);
            System.out.println("您当前的存款金额为"+depositMoney);
        }else{
            System.out.println("请输入正确的金额");
        }

    }
private void truanWright(){
    System.out.println("请选择正确的选项");
     goHome();
}
    private void withdrawMoney() {
        TestUtil.getMoneyUI();
        getMoneyHome();

    }

    private void doSelectMoney() {
        double money= currentCustomer.getMoney();
        System.out.println("余额为"+money);
    }

    private void goHome() {
        TestUtil.oneOption();
        Scanner sc=new Scanner(System.in);
        Integer  a=sc.nextInt();
        choose(a);

    }
    private void getMoneyHome(){
        Scanner sc = new Scanner(System.in);
        double money1 = sc.nextDouble();
        if (currentCustomer.getMoney() < 100) {
            System.out.println("余额不足");
        }else {
            if (money1 == 1) {
                double allMoney = currentCustomer.getMoney() - 100;
                currentCustomer.setMoney(allMoney);
                System.out.println("您当前的存款金额为" + allMoney);
            } else if (money1 == 2) {
                double allMoney = currentCustomer.getMoney() - 200;
                currentCustomer.setMoney(allMoney);
                System.out.println("您当前的存款金额为" + allMoney);
            } else if (money1 == 3) {
                double allMoney = currentCustomer.getMoney() + 300;
                currentCustomer.setMoney(allMoney);
                System.out.println("您当前的存款金额为" + allMoney);
            } else if (money1 == 4) {
                double allMoney = currentCustomer.getMoney() - 500;
                currentCustomer.setMoney(allMoney);
                System.out.println("您当前的存款金额为" + allMoney);
            } else if (money1 == 5) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("请输入你要取款的金额");
                 s = scanner.nextDouble();
                flag = true;
                while (flag) {
                    getMaxMoney();
                }
            }
        }

    }
    public static void getMaxMoney(){
        if (s < 2000 && s>100 && s%100==0) {
            double allMoney = currentCustomer.getMoney() - s;
            currentCustomer.setMoney(allMoney);
            System.out.println("您当前的存款金额为" + allMoney);
            flag = false;
           /* getMaxMoney();*/
        } else {
            System.out.println("请输入正确的金额，最大为2000");
            System.out.println("请输入你要取款的金额，最大为2000");
             Scanner scanner = new Scanner(System.in);
             s = scanner.nextDouble();
            getMaxMoney();
        }
    }
}
