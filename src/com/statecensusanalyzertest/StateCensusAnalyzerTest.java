package com.statecensusanalyzertest;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.statecensusanalyzer.CSVStateCensus;
import com.statecensusanalyzer.StateCensusException;

import junit.framework.Assert;

public class StateCensusAnalyzerTest {
	CSVStateCensus csvStateCensus;
	
	@Before
	public void initialize() {
		csvStateCensus = new CSVStateCensus();
	}
	
	@Test
	public void noOfRecordsMatchesTheResult() throws StateCensusException{
		csvStateCensus.loadCsv("data/census.csv");
		int result = csvStateCensus.getCensusData().getData().size();
		assertEquals(8, result);
	}
	
	@Test
	public void fileNameIsIncorrect() {
		try {
			csvStateCensus.loadCsv("data/census1.csv");
		} catch (StateCensusException e) {
			String expected = "Incorrect Filename!!";
			String result = e.getMessage();
			assertEquals(expected, result);
		}
	}
	
	@Test 
	public void fileTypeIsIncorrect() {
		try {
			csvStateCensus.loadCsv("data/census.txt");
		} catch (StateCensusException e) {
			String expected = "Invalid File Type!!";
			String result = e.getMessage();
			assertEquals(expected, result);
		}
	}
	
	@Test
	public void fileContaininginvalidDelimeter() {
		try {
			csvStateCensus.loadCsv("data/censusdelimiter.csv");
		} catch (StateCensusException e) {
			String expected = "Invalid Delimiters!!";
			String result = e.getMessage();
			assertEquals(expected, result);
		}
	}
	
	@Test
	public void fileContainingInvalidHeader() {
		try {
			csvStateCensus.loadCsv("data/censusheader.csv");
		} catch (StateCensusException e) {
			String expected = "Invalid Header!!";
			String result = e.getMessage();
			assertEquals(expected, result);
		}
	}
	
	@Test
	public void noOfRecordsMatchesTheResultInStateCode() throws StateCensusException{
		csvStateCensus.loadCsv("data/code.csv");
		int result = csvStateCensus.getCensusData().getData().size();
		assertEquals(36, result);
	}
	
	@Test
	public void fileNameIsIncorrectInStateCode() {
		try {
			csvStateCensus.loadCsv("data/code1.csv");
		} catch (StateCensusException e) {
			String expected = "Incorrect Filename!!";
			String result = e.getMessage();
			assertEquals(expected, result);
		}
	}
	
	@Test 
	public void fileTypeIsIncorrectInStateCode() {
		try {
			csvStateCensus.loadCsv("data/code.txt");
		} catch (StateCensusException e) {
			String expected = "Invalid File Type!!";
			String result = e.getMessage();
			assertEquals(expected, result);
		}
	}
	
	@Test
	public void fileContaininginvalidDelimeterInStateCode() {
		try {
			csvStateCensus.loadCsv("data/codedelimiter.csv");
		} catch (StateCensusException e) {
			String expected = "Invalid Delimiters!!";
			String result = e.getMessage();
			assertEquals(expected, result);
		}
	}
	
	@Test
	public void fileContainingInvalidHeaderInStateCode() {
		try {
			csvStateCensus.loadCsv("data/codeheader.csv");
		} catch (StateCensusException e) {
			String expected = "Invalid Header!!";
			String result = e.getMessage();
			assertEquals(expected, result);
		}
	}
	
	
}
