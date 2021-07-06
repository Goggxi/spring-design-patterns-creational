package com.goggxi.springcreational.prototype;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest(classes = PrototypeApplication.class)
class PrototypeApplicationTest {

    @Autowired
    ApplicationContext applicationContext;

    @Test
    void employeePosition() {
        Employee rifkan = applicationContext.getBean("employeeManager", Employee.class);
        rifkan.setName("Rifkan");

        Employee ipang = applicationContext.getBean("employeeStaff", Employee.class);
        ipang.setName("Ipang");

        Employee goggxi = applicationContext.getBean("employeeVicePresident", Employee.class);
        goggxi.setName("Goggxi");

        Employee moh = applicationContext.getBean("employeeCLevel", Employee.class);
        moh.setName("Moh");

        Employee mohRifkan = applicationContext.getBean("employeeCLevel", Employee.class);
        mohRifkan.setName("Moh Rifkan");

        System.out.println(rifkan);
        System.out.println(ipang);
        System.out.println(goggxi);
        System.out.println(moh);
        System.out.println(mohRifkan);
        System.out.println("-----------------");
        System.out.println("Name : " + rifkan.getName());
        System.out.println("Position : " + rifkan.getPosition());
        System.out.println("Salary : " + rifkan.getSalary());
        System.out.println("-----------------");
        System.out.println("Name : " + ipang.getName());
        System.out.println("Position : " + ipang.getPosition());
        System.out.println("Salary : " + ipang.getSalary());
        System.out.println("-----------------");
        System.out.println("Name : " + goggxi.getName());
        System.out.println("Position : " + goggxi.getPosition());
        System.out.println("Salary : " + goggxi.getSalary());
        System.out.println("-----------------");
        System.out.println("Name : " + moh.getName());
        System.out.println("Position : " + moh.getPosition());
        System.out.println("Salary : " + moh.getSalary());
        System.out.println("-----------------");
        System.out.println("Name : " + mohRifkan.getName());
        System.out.println("Position : " + mohRifkan.getPosition());
        System.out.println("Salary : " + mohRifkan.getSalary());
    }
}