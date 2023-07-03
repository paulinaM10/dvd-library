package com.paulina.model.persistence;


import java.util.List;

import com.paulina.dto.entity.Dvd;


public interface DvdDao {
	
	
	List<Dvd> getAllDvds();
	int addDvd(Dvd dvd);
	int deleteDvd(String dvdTitle);
	int updateRecord(String dvdTitle, int userRating);
	Dvd getRecordbyId(int id);
	 Dvd getRecordbyTitle(String dvdTitle);

}
