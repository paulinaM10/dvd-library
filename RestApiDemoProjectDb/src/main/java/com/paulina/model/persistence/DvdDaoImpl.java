package com.paulina.model.persistence;

import java.util.List;
import com.paulina.model.persistence.DvdMapper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.paulina.dto.entity.Dvd;
import com.paulina.model.persistence.*;


import com.paulina.model.service.*;


@Repository
public class DvdDaoImpl implements DvdDao {

	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
//	@Override
//	public List<Dvd> getAllDvds() {
//		     String query = "SELECT * FROM DVD";
//		     return jdbcTemplate.query(query, new DvdMapper());
//
//	}
  @Override 
  public List<Dvd> getAllDvds() {
	  return jdbcTemplate.query("SELECT * FROM DVD", new DvdMapper());
	  
  }
	
	
	
	@Override
	public int addDvd(Dvd dvd) {
		String query = "INSERT INTO DVD VALUES(?,?,?,?,?,?)";
       return jdbcTemplate.update(query, dvd.getDvdId(), dvd.getDvdTitle(), 
    		   dvd.getDvdMpaa(), dvd.getDvdDirector(), dvd.getDvdStudio(), dvd.getDvdUserRating());

	}
			
			
	@Override
	public int deleteDvd(String dvdTitle) {
		   try {
			   return jdbcTemplate.update("DELETE FROM DVD WHERE DVD_TITLE=?", dvdTitle);
		   }catch (Exception ex) {
			   return 0;
		   }

			
	}
				
	@Override
	public int updateRecord(String dvdTitle, int userRating) {
		try {
			return jdbcTemplate.update("UPDATE DVD SET USER_RATING=? WHERE DVD_TITLE =? ", userRating, dvdTitle);
		}catch (Exception ex) {
			return 0;
		}
		
	}


	@Override
	public Dvd getRecordbyId(int id) {
		try {
			  return jdbcTemplate.queryForObject("SELECT * FROM DVD WHERE DVD_ID=?", new DvdMapper(), id );
		
		}
		catch(EmptyResultDataAccessException ex) {
		return null;
	}

	}
	
	
	@Override
	public Dvd getRecordbyTitle(String dvdTitle) {
		try {
			  return jdbcTemplate.queryForObject("SELECT * FROM DVD WHERE DVD_TITLE=?", new DvdMapper(), dvdTitle );
		
		}
		catch(EmptyResultDataAccessException ex) {
		return null;
	}

	}
}
	

