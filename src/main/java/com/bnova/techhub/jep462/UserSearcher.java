package com.bnova.techhub.jep462;

public class UserSearcher
{
	public static String findTom() throws InterruptedException
	{
		Thread.sleep(5000);
		System.out.println("Tom found");
		return "Tom";
	}

	public static String findTim()
	{
		throw new RuntimeException("Tim not found");
		// System.out.println("Tim found");
		// return "Tim";
	}
}
