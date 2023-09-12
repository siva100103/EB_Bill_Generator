package com.wipro.eb.main;
import java.util.*;
import com.wipro.eb.service.*;
public class EBMain {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the current reading: ");
		int currentReading=sc.nextInt();
		System.out.println("Enter the Previous Reading: ");
		int previousReading=sc.nextInt();
		System.out.println("Enter the type: ");
		String type=sc.next();
		System.out.println(new ConnectionService().generateBill(currentReading,previousReading,type));
	}

}
