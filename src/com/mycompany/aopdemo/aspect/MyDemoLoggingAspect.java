package com.mycompany.aopdemo.aspect;


import com.mycompany.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {

    private Logger myLogger = Logger.getLogger(getClass().getName());

    //Add @Around advice

    //to handle exceptions proceedingJoinPoints should be put into try\catch. catch block will cathc the exception, then you can modify the result and suppress the exception and just send regualr message to mainAPP.
    //Or exception could ber rethrowable using 'throw'
    @Around(value = "execution(* com.mycompany.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable   {
        String method = proceedingJoinPoint.getSignature().toShortString();
        myLogger.info("@AROUND: executing method: " + method);
        long begin = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed();
        result = result+ "asdcad";
        long end = System.currentTimeMillis();
        long duration = end - begin;
        myLogger.info("@AROUND: method duration: " + duration + " ms");
        return result;
    }

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
