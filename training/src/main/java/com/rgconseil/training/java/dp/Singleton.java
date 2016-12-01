package com.rgconseil.training.java.dp;

public class Singleton {

	private final static Singleton instance = new Singleton();

	private Singleton() {
	}
	
	public static Singleton getInstance(){
		return instance;
	}

}
