package com.paulina.dvd.service;

import java.util.Iterator;
import java.util.LinkedList;



import com.paulina.dvd.dto.Dvd;
import com.paulina.dvd.persistence.DvdDataAccess;
import com.paulina.dvd.persistence.DvdDataAccessImpl;


public class DvdBussinessLogicImpl implements DvdBussinessLogic {
	
	private DvdDataAccess dataAccess=new DvdDataAccessImpl();
	
    private LinkedList<Dvd> dvdList;
	
	public DvdBussinessLogicImpl() {
		try {
			dvdList=dataAccess.readRecords();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean deleteDvd(String title) {
	    Iterator<Dvd> iterator = dvdList.iterator();
	    while (iterator.hasNext()) {
	        Dvd dvd = iterator.next();
	        if (title.equals(dvd.getTitle())) {
	            iterator.remove();
	            return true;
	        }
	    }
	    return false;
	}

	@Override
	public void saveAllDvds() throws Exception {
		// TODO Auto-generated method stub
		dataAccess.writeRecords(dvdList);

	}

	@Override
	public LinkedList<Dvd> getAllDvd() {
		// TODO Auto-generated method stub
		return dvdList;
	}

	@Override
	public boolean addDvd(Dvd dvd) {
		// TODO Auto-generated method stub
		return dvdList.add(dvd);
	}

	@Override
		public void editDvd(Dvd editDvd) {
	        for (int i = 0; i < dvdList.size(); i++) {
	            if (dvdList.get(i).getTitle().equals(editDvd.getTitle())) {
	                dvdList.set(i, editDvd);  
	                break;
	            }
	        }
		}

	@Override
	public Dvd searchDvdByTitle(String title) {
        for (Dvd dvd : dvdList) {
            if (dvd.getTitle().equals(title)) {
                return dvd;  
            }
        }
        return null;
    }

	@Override
	public boolean isDvdPresent(String title) {
        for (Dvd dvd : dvdList) {
            if (dvd.getTitle().equals(title)) {
                return true;  
            }
        }
        return false;
    }

}
