package com.nt.aspects;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class CacheAdvice implements MethodInterceptor {
	Map<String, Object> map = new HashMap<>();

	@Override
	public Object invoke(MethodInvocation i) throws Throwable {
		Object retval = null;
		String key = i.getMethod().getName() + Arrays.toString(i.getArguments());
		if (!map.containsKey(key)) {
			retval = i.proceed();
			map.put(key, retval);
			System.out.println("From target method");
			return retval;
		} else
			retval = map.get(key);
		System.out.println("from cache");
		return retval;
	}

}
