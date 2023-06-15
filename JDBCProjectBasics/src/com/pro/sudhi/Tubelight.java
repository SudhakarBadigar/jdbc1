package com.pro.sudhi;

public class Tubelight implements Iswitch {

	@Override
	public void on() {
		System.out.println("Tubelight is on");
	}

	@Override
	public void off() {
		System.out.println("Tubelight is off");
	}
}
