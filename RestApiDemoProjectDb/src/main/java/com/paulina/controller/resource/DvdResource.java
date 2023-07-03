package com.paulina.controller.resource;

import org.springframework.web.bind.annotation.RestController;

import com.paulina.dto.entity.Dvd;
import com.paulina.dto.entity.DvdList;
import com.paulina.model.service.DvdService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DvdResource {
	
	@Autowired
	DvdService dvdService;
	
	
	@CrossOrigin
	@GetMapping(path="/dvds",produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<DvdList> getAllDvds() {
		DvdList dvdList= new DvdList(dvdService.getAllDvds());
		if(dvdList.getDvds().size()>0)
			return new ResponseEntity<DvdList>(dvdList,HttpStatus.OK);
		else
			return new ResponseEntity<DvdList>(dvdList,HttpStatus.NO_CONTENT);
	}
	
	
	
	@CrossOrigin
	@GetMapping(path = "/dvds/id/{dvdId}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Dvd> getRecordById(@PathVariable("dvdId") int id) {
		Dvd dvd=dvdService.getRecordById(id);
		ResponseEntity<Dvd> response=null;
		if(dvd!=null)
			response=new ResponseEntity<Dvd>(dvd, HttpStatus.FOUND);
		else
			response=new ResponseEntity<Dvd>(dvd,HttpStatus.NOT_FOUND);
		return response;
	}
	

	@CrossOrigin
	@GetMapping(path = "/dvds/title/{dvdTitle}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Dvd> getRecordByTitle(@PathVariable("dvdTitle") String dvdTitle) {
		Dvd dvd=dvdService.getRecordByTitle(dvdTitle);
		ResponseEntity<Dvd> response=null;
		if(dvd!=null)
			response=new ResponseEntity<Dvd>(dvd, HttpStatus.FOUND);
		else
			response=new ResponseEntity<Dvd>(dvd,HttpStatus.NOT_FOUND);
		return response;
	}
	
	@PostMapping(path = "/dvds",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Dvd> addDvd(@RequestBody Dvd dvd) {
		if(dvdService.addDvd(dvd))
			return new ResponseEntity<Dvd>(dvd, HttpStatus.CREATED);
		else
			return new ResponseEntity<Dvd>(HttpStatus.NOT_ACCEPTABLE);
	}
	

	
	@DeleteMapping(path = "/dvds/{dvdTitle}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> deleteDvd(@PathVariable String dvdTitle) {
	    boolean deleted = dvdService.deleteDvd(dvdTitle);
	    if (deleted) {
	        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	    } else {
	        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	    }
	}

	
	@PutMapping(path = "/dvds/{dvdTitle}/{rating}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Dvd> updateDvd(@PathVariable("dvdTitle") String dvdTitle ,@PathVariable("rating") int userRating){
		
		Dvd dvd=dvdService.editTheRecord(dvdTitle, userRating);
		if(dvd!=null)
			return new ResponseEntity<Dvd>(dvd, HttpStatus.OK);
		else
			return new ResponseEntity<Dvd>(HttpStatus.BAD_REQUEST);
			
	}
	
	
}


