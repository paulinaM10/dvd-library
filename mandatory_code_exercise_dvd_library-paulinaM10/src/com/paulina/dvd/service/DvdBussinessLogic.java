package com.paulina.dvd.service;

import java.util.LinkedList;

import com.paulina.dvd.dto.Dvd;



public interface DvdBussinessLogic {
	
	LinkedList<Dvd> getAllDvd();
	boolean addDvd(Dvd dvd);
	public void saveAllDvds()throws Exception;
	boolean deleteDvd(String title);
	void editDvd(Dvd editDvd);
	Dvd searchDvdByTitle(String editTitle);
	boolean isDvdPresent(String checkTitle);

}
