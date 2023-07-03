package com.paulina.model.service;

import com.paulina.dto.entity.*;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import com.paulina.model.persistence.*;

@Service
public
class DvdServiceImpl implements DvdService {

	
	@Autowired
	private DvdDao dvdDao;
	
	
	@Override
	public List<Dvd> getAllDvds() {
		
		return dvdDao.getAllDvds();
	}

	@Override
    public boolean addDvd(Dvd dvd) {
        if (getRecordById(dvd.getDvdId()) == null) {
            dvdDao.addDvd(dvd);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteDvd(String dvdTitle) {
        Dvd dvd = getRecordByTitle(dvdTitle);

        if(dvd != null) {
            dvdDao.deleteDvd(dvdTitle);
            return true;
        }

        return false;
    }
	

	@Override
	public Dvd editTheRecord(String dvdTitle, int userRating) {
	
		if(dvdDao.updateRecord(dvdTitle, userRating)>0)
			return getRecordByTitle(dvdTitle);
		return null;
		
	}

	@Override
	public Dvd getRecordById(int id) {
     return dvdDao.getRecordbyId(id);
	}

	@Override
	public Dvd getRecordByTitle(String dvdTitle) {
		return dvdDao.getRecordbyTitle(dvdTitle);
	}

}
