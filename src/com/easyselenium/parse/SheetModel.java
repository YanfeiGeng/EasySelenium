package com.easyselenium.parse;

import java.util.List;

public class SheetModel {
	
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

	public SheetModel(List<String> header, List<RowModel> body) {
		super();
		this.header = header;
		this.body = body;
	}
	
}
