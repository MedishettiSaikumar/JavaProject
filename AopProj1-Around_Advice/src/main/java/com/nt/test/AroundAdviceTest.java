package com.nt.test;


import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.target.IntAmtCalculator;
import com.nt.target.IntAmtCalcy;

public class AroundAdviceTest {

	public static void main(String[] args) {
		ApplicationContext ctx = null;
		IntAmtCalcy proxy = null;
		// create the IOC Container
		ctx = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		proxy = ctx.getBean("pfb", IntAmtCalcy.class);
		
		// invoke the Method
        System.out.println(proxy.getClass().getMethods()+" "+proxy.getClass().getName()+" "+Arrays.toString(proxy.getClass().getMethods()));
		System.out.println("SimpleAmt:::" + proxy.simpleIntrAmtCalc(35000, 2, 3));
		System.out.println("----------------------------------------------------------------------");
		System.out.println("SimpleAmt:::" + proxy.simpleIntrAmtCalc(35000, 2, 3));
		System.out.println("----------------------------------------------------------------------");
		System.out.println("SimpleAmt:::" + proxy.simpleIntrAmtCalc(90000, 2, 4));
		// stop the Container
		((AbstractApplicationContext) ctx).close();
	}

}
