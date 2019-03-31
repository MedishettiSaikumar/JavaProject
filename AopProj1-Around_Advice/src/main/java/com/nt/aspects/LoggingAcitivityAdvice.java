package com.nt.aspects;

import java.util.Arrays;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LoggingAcitivityAdvice implements MethodInterceptor {
	long start, end;

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		Object retVal;

		System.out.println(invocation.getMethod().getName() + " Class Has taken"
				+ Arrays.toString(invocation.getArguments()) + "Has Logged in");
		// controlling the arguments values
		Object args[] = invocation.getArguments();
		if ((Float) args[0] < 500000) {
			args[1] = 1.0f;
		}
		// controlling the arguments method;
		if ((Float) args[0] == 0.0f || (Float) args[1] == 0.0f || (Float) args[2] == 0.0f) {
			return 4.0f;

		} else {
			retVal = invocation.proceed();
		}
		System.out.println(invocation.getMethod().getName() + " Class Has taken"
				+ Arrays.toString(invocation.getArguments()) + "Has Logged Out in " + (start - end) + "ms");
		if((Float)retVal<=25000)
		return retVal;
		else
			return ((Float)retVal+(Float)retVal)*0.2f;	
		
	}

}
