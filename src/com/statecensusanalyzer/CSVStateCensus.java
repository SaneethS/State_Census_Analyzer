package com.statecensusanalyzer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;

public class CSVStateCensus {
	CensusData censusData;
	
	public CensusData getCensusData() {
		return censusData;
	}

	public void setCensusData(CensusData censusData) {
		this.censusData = censusData;
	}

	public void loadCsv(String fileName) throws StateCensusException{
		try {
			String fileType = fileName.substring(fileName.lastIndexOf("."));
			if(!(fileType.contains(".csv"))){
				throw new StateCensusException("Invalid File Type!!");
			}
			File file = new File(fileName);
			if(!(file.exists())) {
				System.out.println("File does not exist!!");
				return;
			}
		
		
			CSVReader reader = new CSVReader(new FileReader(file));
			String[] header = reader.readNext();
			List<String[]> list = reader.readAll();
			censusData = new CensusData(header,list);
			reader.close();
			
		} catch (FileNotFoundException e) {
			throw new StateCensusException("Incorrect Filename!!");
		} catch (StateCensusException e) {
			throw e;
		}catch (CsvValidationException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (CsvException e) {
			e.printStackTrace();
		}
		
	}
}
