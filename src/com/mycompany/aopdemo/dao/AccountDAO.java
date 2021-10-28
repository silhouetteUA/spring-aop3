package com.mycompany.aopdemo.dao;

import com.mycompany.aopdemo.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDAO {

    private String name;
    private String serviceCode;



    public List<Account> findAccounts(boolean flag) {
        if(flag){
            throw new RuntimeException("aaaaaaaaaaaaaa, my exception is being fired !");
        }

        List<Account> myAccounts = new ArrayList<>();
        Account temp1 = new Account("John","Silver");
        Account temp2 = new Account("Doe","Gold");
        myAccounts.add(temp1);
        myAccounts.add(temp2);
        return myAccounts;
    }

    public void addAccount(Account account, boolean vipFlag)    {
        System.out.println(getClass() + ": Doing my DB work: adding an account");
    }

    public AccountDAO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }
}
