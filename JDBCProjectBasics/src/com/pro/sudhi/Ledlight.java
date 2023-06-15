package com.pro.sudhi;

public class Ledlight implements Iswitch{

	@Override
	public void on() {
		System.out.println("LedLight is on");		
	}

	@Override
	public void off() {
		System.out.println("LedLight is off");
	}

}
