package com.paulina.dvd.persistence;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

import com.paulina.dvd.dto.Dvd;

public class DvdDataAccessImpl implements DvdDataAccess {

	@Override
	public boolean writeRecords(LinkedList<Dvd> dvds)throws Exception {
		FileWriter fileWriter=new FileWriter("DvdData");
		PrintWriter printWriter=new PrintWriter(fileWriter);
		
		for(Dvd dvd:dvds) {
			String dvdStr=dvd.getTitle()+","+dvd.getDate()+","+dvd.getRating()+","+dvd.getDirectorsName()+","+dvd.getStudio()+","+dvd.getUserNote();
			
			printWriter.println(dvdStr);
		}
		
		printWriter.flush();
		
		printWriter.close();

		fileWriter.close();
		return true;
	}

	@Override
	public LinkedList<Dvd> readRecords()throws Exception {
		LinkedList<Dvd> dvds=new LinkedList<Dvd>();
		
		FileReader fileReader = new FileReader("DvdData");

		// read the content from buffer
		BufferedReader bufferedReader = new BufferedReader(fileReader);

		Scanner scanner = new Scanner(bufferedReader);
		while (scanner.hasNext()) {
			String currentLine = scanner.nextLine();
			
			String values[]=currentLine.split(",");
			
			Dvd dvd=new Dvd((values[0]), values[1], values[2], values[3],values[4], values[5]);
			
			dvds.add(dvd);
		}
		fileReader.close();
		bufferedReader.close();
		
		return dvds;
	}

}