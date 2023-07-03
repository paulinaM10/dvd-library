package com.paulina.model.service;


import java.util.List;

import com.paulina.dto.entity.Dvd;


public interface DvdService {
	
	
	List<Dvd> getAllDvds();
	boolean addDvd(Dvd dvd);
	boolean deleteDvd(String dvdTitle);
	Dvd editTheRecord(String dvdTitle, int userRating);
	Dvd getRecordById(int id);
	Dvd getRecordByTitle(String dvdTitle);

}
