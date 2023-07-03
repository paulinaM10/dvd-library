package com.paulina.dto.entity;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;



@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class DvdList {
	
	private List<Dvd> dvds;

}
