package com.mycompany.aopdemo.aspect;


import com.mycompany.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Aspect
@Component
@Order(2)
public class MyApiAnalyticsAdvice {


//    @Before(value = "com.mycompany.aopdemo.aspect.MyDemoLoggingAspect.forDaoPackageNoGetterSetter()")
//    public void performApiAnalyticsAdvice(JoinPoint joinPoint)   {
//        System.out.println("=====> Executing PerformAnalytics Advice");
//
//        //display the method signature
//        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
//        System.out.println("Method signature: " + methodSignature);
//
//        //display method arguments
//        Object[] args = joinPoint.getArgs();
//        for(Object element:args)   {
//            System.out.println(element);
//            if (element instanceof Account) {
//                Account theAccount = (Account) element;
//                System.out.println("Account Name: " +((Account) element).getName());
//                System.out.println("Account Level: " +((Account) element).getLevel());
//            }
//        }
//    }


}
