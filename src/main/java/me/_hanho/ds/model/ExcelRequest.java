package me._hanho.ds.model;

import java.util.List;

public class ExcelRequest {

	private List<List<String>> list;
	
	public ExcelRequest() {
		// TODO Auto-generated constructor stub
	}

	public ExcelRequest(List<List<String>> list) {
		super();
		this.list = list;
	}

	public List<List<String>> getList() {
		return list;
	}

	public void setList(List<List<String>> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "ExcepRequest [list=" + list + "]";
	}
}
