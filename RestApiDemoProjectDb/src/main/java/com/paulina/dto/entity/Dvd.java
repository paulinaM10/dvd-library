package com.paulina.dto.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString


public class Dvd {
	
	
	private int dvdId;
	private String dvdTitle;
	private int dvdMpaa;
	private String dvdDirector;
	private String dvdStudio;
	private int dvdUserRating;

}
