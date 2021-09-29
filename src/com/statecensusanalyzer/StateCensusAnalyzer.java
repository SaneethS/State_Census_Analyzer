package com.statecensusanalyzer;

public class StateCensusAnalyzer {
	
	public static void main(String[] args) throws StateCensusException {
		CSVStateCensus csvStateCensus = new CSVStateCensus();
		csvStateCensus.loadCsv("data/census.csv");
		
		CensusData censusData = csvStateCensus.getCensusData();
		
	}
}
