package com.easyselenium.parse;

import java.util.List;

public class ExcelModel {
	
	private List<String> header;
	
	private List<ExcelRow> body;

	public List<String> getHeader() {
		return header;
	}

	public void setHeader(List<String> header) {
		this.header = header;
	}

	public List<ExcelRow> getBody() {
		return body;
	}

	public void setBody(List<ExcelRow> body) {
		this.body = body;
	}
	
}
