package com.easyselenium.parse;

import java.util.List;

public class RowModel {

	private List<String> cells;

	public List<String> getCells() {
		return cells;
	}

	public void setCells(List<String> cells) {
		this.cells = cells;
	}

	public RowModel(List<String> cells) {
		super();
		this.cells = cells;
	}
	
	
}
