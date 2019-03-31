package com.nt.aspects;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class PerfromingMontoringAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation method) throws Throwable {
		long start, end;
		Object retval;

		start = System.currentTimeMillis();
		retval = method.proceed();
		end = System.currentTimeMillis();
		System.out.println(
				method.getMethod().getName() + " has Taken " + (end - start) + " ms to complete the exceution");

		return retval;
	}

}
