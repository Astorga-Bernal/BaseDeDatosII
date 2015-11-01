package src.mysql;

import java.util.LinkedList;

public class Index {
	private String name;
	private LinkedList<Column> colums;

	public Index() {
		super();
	}

	public Index(String name, LinkedList<Column> colums) {
		super();
		this.name = name;
		this.colums = colums;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LinkedList<Column> getColums() {
		return colums;
	}

	public void setColums(LinkedList<Column> colums) {
		this.colums = colums;
	}

}
