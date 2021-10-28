package com.mycompany.aopdemo.dao;


import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
    public void addAccount() {
        System.out.println(getClass()+": DOING STUFF: Membership class");
    }

    public void addSillyMember()    {
        System.out.println(getClass() + ": ADDING SILLY MEMBER: Membership class");
    }

    public boolean addSomeShit()    {
        System.out.println(getClass() + "Doing some shit from Membership DAO");
        return false;
    }
}
