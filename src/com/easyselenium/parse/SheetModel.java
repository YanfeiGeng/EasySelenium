package com.easyselenium.parse;

import java.util.List;

public class SheetModel {
	
	private String name;
	
	private List<String> header;
	
	private List<RowModel> body;

	public List<String> getHeader() {
		return header;
	}

	public void setHeader(List<String> header) {
		this.header = header;
	}

	public List<RowModel> getBody() {
		return body;
	}

	public void setBody(List<RowModel> body) {
		this.body = body;
	}

	public SheetModel(String name, List<String> header, List<RowModel> body) {
		super();
		this.name = name;
		this.header = header;
		this.body = body;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
