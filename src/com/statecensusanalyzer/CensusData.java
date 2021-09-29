package com.statecensusanalyzer;

import java.util.List;

public class CensusData {
	String[] header;
	List<String[]> data;
	
	public CensusData(String[] header, List<String[]> data) {
		this.header = header;
		this.data = data;
	}

	public String[] getHeader() {
		return header;
	}

	public void setHeader(String[] header) {
		this.header = header;
	}

	public List<String[]> getData() {
		return data;
	}

	public void setData(List<String[]> data) {
		this.data = data;
	}
}
