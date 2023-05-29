package com.paulina.dvd.presentation;

import java.util.LinkedList;
import java.util.Scanner;


import com.paulina.dvd.dto.Dvd;
import com.paulina.dvd.service.DvdBussinessLogic;
import com.paulina.dvd.service.DvdBussinessLogicImpl;

public class DvdUserInterfaceImpl implements DvdUserInterface {
	
	
	private DvdBussinessLogic bussinessLogic=new DvdBussinessLogicImpl();

	@Override
	public void showMenu() {
			System.out.println("1. Show all DVDs in the collection.");
			System.out.println("2. Remove DVD from the collection.");
			System.out.println("3. Edit the information for an existing DVD.");
			System.out.println("4. Add DVD to the collection.");
			System.out.println("5. Check if the DVD is in the collection");
			System.out.println("6. Search DVD by the title.");
			System.out.println("7. Save and Exit.");

	}

	@Override
	public void performMenu(int choice)throws Exception {
		
		Scanner scanner=new Scanner(System.in);
		switch (choice) {
		case 1: 
			//show all dvds
			LinkedList<Dvd> dvds=bussinessLogic.getAllDvd();
			for(Dvd dvd:dvds) {
				System.out.println(dvd);
			}
			break;
		case 2:
			System.out.println("Enter DVD Title you want to delete : ");
			String title=scanner.next();
			if(bussinessLogic.deleteDvd(title))
				System.out.println("Dvd Deleted");
			else
				System.out.println("Dvd with title "+title+" does not exist");
			break;
			
		case 3:
			//edit the info
			System.out.println("Enter the title of the DVD you want to edit : ");
	        String editTitle = scanner.next();
	        Dvd editDvd = bussinessLogic.searchDvdByTitle(editTitle);
	        if(editDvd != null) {
	            System.out.println("Enter new Release date : ");
	            editDvd.setDate(scanner.next());
	            System.out.println("Enter new MPPA rating : ");
	            editDvd.setRating(scanner.next());
	            System.out.println("Enter new Director's name : ");
	            editDvd.setDirectorsName(scanner.next());
	            System.out.println("Enter new Studio: ");
	            editDvd.setStudio(scanner.next());
	            System.out.println("Enter Your new Note: ");
	            editDvd.setUserNote(scanner.next());
	            bussinessLogic.editDvd(editDvd);
	            System.out.println("DVD updated successfully!");
	        } else {
	            System.out.println("No DVD found with title " + editTitle);
	        }
	        break;
		case 4:
			//add dvd 
			Dvd dvd=new Dvd();
			System.out.println("Enter the title : ");
			dvd.setTitle(scanner.next());
			System.out.println("Enter Release date : ");
			dvd.setDate(scanner.next());
			System.out.println("Enter MPPA rating : ");
			dvd.setRating(scanner.next());
			System.out.println("Enter Director's name : ");
			dvd.setDirectorsName(scanner.next());
			System.out.println("Enter Studio: ");
			dvd.setStudio(scanner.next());
			System.out.println("Enter Your Note: ");
			dvd.setUserNote(scanner.next());

			boolean status=bussinessLogic.addDvd(dvd);
			
			if(status)
				System.out.println("Dvd Added!");
			else
				System.out.println("Dvd Not Added!");
			break;
			
		case 5:
			//check if the dvd is in the collection
			System.out.println("Enter the title of the DVD you want to check : ");
	        String checkTitle = scanner.next();
	        if(bussinessLogic.isDvdPresent(checkTitle)) {
	            System.out.println("DVD is present in the collection.");
	        } else {
	            System.out.println("No DVD found with title " + checkTitle);
	        }
	        break;
			
		case 6:
			//search dvd by the title 
			System.out.println("Enter the title of the DVD you want to search : ");
	        String searchTitle = scanner.next();
	        Dvd searchedDvd = bussinessLogic.searchDvdByTitle(searchTitle);
	        if(searchedDvd != null) {
	            System.out.println(searchedDvd);
	        } else {
	            System.out.println("No DVD found with title " + searchTitle);
	        }
	        break;
			
			
		case 7:
			//save and exit
			bussinessLogic.saveAllDvds();
			System.out.println("Thanks for Using DVD Management System");
			System.exit(0);
			break;
			
		default:
			System.out.println("Invalid Choice");
		}

	}

}