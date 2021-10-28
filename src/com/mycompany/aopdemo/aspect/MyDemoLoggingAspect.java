package com.mycompany.aopdemo.aspect;


import com.mycompany.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {

    //Add new @After advice
    @After(value = "execution(* com.mycompany.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFindAccountAdvice(JoinPoint joinPoint)    {
        System.out.println("@After advice in work .. doing some stuff");
    }

    //Add new ADVICE @AfterThrowing

    @AfterThrowing(pointcut = "execution(* com.mycompany.aopdemo.dao.AccountDAO.findAccounts(..))",
                    throwing = "myThrowing")
    public void afterThrowingFindAccountAdvice(JoinPoint joinPoint, Throwable myThrowing)    {
        String method = joinPoint.getSignature().toShortString();
        System.out.println("Invoked method inside @AfterThrowing: " + method);
        System.out.println("The exception is: " + myThrowing);

    }

    //Add new ADVICE on find accounts method, @AfterReturning

    @AfterReturning(pointcut = "execution(* com.mycompany.aopdemo.dao.AccountDAO.findAccounts(..))",
                    returning = "myresults")
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> myresults)  {
        //print method which is being called
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n Executing @AfterReturning on method: "+method);


        //print the results of method call
        System.out.println("\n Result is : "+myresults);


        //post-process, modify the data
        convertAccountNamesToUpperCase(myresults);
        System.out.println("\n Modified Result is : "+myresults);
    }

    private void convertAccountNamesToUpperCase(List<Account> myresults) {
        for (Account element:myresults) {
            String toUpperCase = element.getName().toUpperCase();
            element.setName(toUpperCase);
        }
    }






//    @Pointcut("execution(* com.mycompany.aopdemo.dao.*.*(..))")
//    public void forDaoPackage(){}
//
//    @Pointcut("execution(* com.mycompany.aopdemo.dao.*.get*(..))")
//    public void getter(){}
//
//    @Pointcut("execution(* com.mycompany.aopdemo.dao.*.set*(..))")
//    public void setter(){}
//
//    //combine pointcut
//    @Pointcut("forDaoPackage() && !(getter() || setter())")
//    public void forDaoPackageNoGetterSetter(){}

    //here  we add all of our related advices for logging

    //@Before(value = "execution(public void addAccount())")
    //@Before(value = "execution(public void com.mycompany.aopdemo.dao.addAccount())")
    //@Before(value = "execution(public void add*())")
    //@Before(value = "execution(* add*())")
    //@Before(value = "execution(* add*(com.mycompany.aopdemo.Account))")
    //@Before(value = "execution(* add*(com.mycompany.aopdemo.Account, ..))")
    //@Before(value = "execution(* add*(..))")
    //@Before(value = "execution(* com.mycompany.aopdemo.dao.*.*(..))")
    //@Before("forDaoPackage()")
//    @Before("forDaoPackageNoGetterSetter()")
//    public void beforeAddAccountAdvice(){
//        System.out.println("=====> Executing @Before advice on addAccount");
//    }


}
