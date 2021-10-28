package com.mycompany.aopdemo;

import com.mycompany.aopdemo.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainDemoApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

//        List<Account> accountList = accountDAO.findAccounts();
//        System.out.println("\n\n Main Program: AfterReturningDemoApp");
//        System.out.println("----------------");
//        System.out.println(accountList);
//        System.out.println("\n");

        List<Account> accountList = null;
        try {
            accountList = accountDAO.findAccounts(true);
        } catch (Exception e)  {
            System.out.println("\n\n Main program caught exception: " +e.getMessage());
        }


        context.close();


    }
}
