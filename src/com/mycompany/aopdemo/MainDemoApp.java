package com.mycompany.aopdemo;

import com.mycompany.aopdemo.dao.AccountDAO;
import com.mycompany.aopdemo.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.logging.Logger;

public class MainDemoApp {

    private static Logger myLogger = Logger.getLogger(MainDemoApp.class.getName());


    public static void main(String[] args) {


        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
 //       AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

//        List<Account> accountList = accountDAO.findAccounts();
//        System.out.println("\n\n Main Program: AfterReturningDemoApp");
//        System.out.println("----------------");
//        System.out.println(accountList);
//        System.out.println("\n");

//        List<Account> accountList = null;
//        try {
//            accountList = accountDAO.findAccounts(true);
//        } catch (Exception e)  {
//            System.out.println("\n\n Main program caught exception: " +e.getMessage());
//        }

        TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
        myLogger.info("\n\nMain Program ===>>> Calling getFortune()");
        myLogger.info(trafficFortuneService.getFortune());
        myLogger.info("Finished!");

        context.close();


    }
}
