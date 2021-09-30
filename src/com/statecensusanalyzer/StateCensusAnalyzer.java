package com.statecensusanalyzer;

import java.util.Arrays;

public class StateCensusAnalyzer {
	
	public static void main(String[] args) throws StateCensusException {
		CSVStateCensus csvStateCensus = new CSVStateCensus();
		csvStateCensus.loadCsv("data/census.csv");
		
		CensusData censusData1 = csvStateCensus.getCensusData();
		
		System.out.println(Arrays.toString(censusData1.getHeader()));
		System.out.println();
		
		for(String[] i: censusData1.getData()) {
			System.out.println(Arrays.toString(i));
		}
		
		System.out.println("\n\n");
		
		CSVStateCensus csvStateCode = new CSVStateCensus();
		csvStateCode.loadCsv("data/code.csv");
		
		CensusData censusData2 = csvStateCode.getCensusData();
		
		System.out.println(Arrays.toString(censusData2.getHeader()));
		System.out.println();
		
		for(String[] i: censusData2.getData()) {
			System.out.println(Arrays.toString(i));
		}
	}
}
