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
}
