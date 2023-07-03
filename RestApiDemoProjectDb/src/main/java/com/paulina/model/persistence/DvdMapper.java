package com.paulina.model.persistence;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.paulina.model.service.*;
import com.paulina.dto.entity.Dvd;
import com.paulina.model.persistence.*;
public class DvdMapper implements RowMapper<Dvd> {

	@Override
	public Dvd mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		int id = resultSet.getInt("DVD_ID");
		String title = resultSet.getString("DVD_TITLE");
		int mpaa = resultSet.getInt("MPAA");
		String director = resultSet.getString("DIRECTOR_NAME");
		String studio = resultSet.getString("STUDIO");
		int userRating = resultSet.getInt("USER_RATING");

		Dvd dvd = new Dvd(id, title, mpaa, director, studio, userRating); 
		

		
		return dvd;
	}

}
