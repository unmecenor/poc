package com.rgconseil.training.java.dp;

public final class SingletonLate {

	private SingletonLate() {
	}

	private static class SingletonWrapper {
		public static SingletonLate instance = new SingletonLate();
	}

	public static SingletonLate getInstance() {
		return SingletonWrapper.instance;
	}

}
