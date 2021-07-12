package com.hp.bean;

import java.util.ArrayList;
import java.util.List;

public class CustomerData {
    private static CustomerData ourInstance = new CustomerData();
    private List<Customer> list;

    public List<Customer> getList() {
        return list;
    }

    public void setList(List<Customer> list) {
        this.list = list;
    }

    public static CustomerData getInstance() {
        return ourInstance;
    }

    private CustomerData() {
    list= new ArrayList<>();
        for (int i = 0; i <10 ; i++) {
            Customer c=new Customer();
            c.setAccount("5201314"+i);
            c.setPwd("123");
            c.setCname("葫芦娃"+i);
            c.setMoney(10000);
            c.setPhone("1513784"+i);
            list.add(c);
        }
    }

}
