package com.nt.target;

public class IntAmtCalculator  implements IntAmtCalcy{
	@Override
	public float simpleIntrAmtCalc(float principal,float rate,float time) {
		return (principal*rate*time)/100.0f;
	}

}
