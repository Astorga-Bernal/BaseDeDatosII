package src.mysql;

import java.util.LinkedList;

public class PrimaryKey {

	private String name;
	private LinkedList<Column> columns;

	public PrimaryKey() {
		super();
	}

	public PrimaryKey(String name, LinkedList<Column> colums) {
		super();
		this.name = name;
		this.columns = colums;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LinkedList<Column> getColums() {
		return columns;
	}

	public void setColums(LinkedList<Column> colums) {
		this.columns = colums;
	}

}
