package com.paulina.dvd.client;

import java.util.Scanner;

import com.paulina.dvd.presentation.*;

public class DvdClient {

	public static void main(String[] args) {
		DvdUserInterface dvdUserInterface=new DvdUserInterfaceImpl();
		Scanner scanner=new Scanner(System.in);
		while(true) {
			dvdUserInterface.showMenu();
			System.out.println("Enter Choice : ");
			int choice=scanner.nextInt();
			try {
				dvdUserInterface.performMenu(choice);
			} catch (Exception e) {
				System.out.println("Something went wrong , please try after sometime!");
			}
			
		}

	}

}