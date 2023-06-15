package com.pro.sudhi;

import java.util.Scanner;

public class MainFactorySudhi {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the type of light you want");
		String choice = scan.next();
		Iswitch light = LightFactory.getLight(choice);
		
		if(light!=null) {
		light.on();
		light.off();
		}
		scan.close();
	}

}
