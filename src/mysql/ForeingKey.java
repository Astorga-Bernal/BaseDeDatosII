package src.mysql;

import java.util.LinkedList;

public class ForeingKey {

	private String name;
	private String table;
	private LinkedList<Column> colums;
	private LinkedList<Restiction> restriction;

	public ForeingKey() {
		super();
	}

	public ForeingKey(String name, String table, LinkedList<Column> colums, LinkedList<Restiction> restriction) {
		super();
		this.name = name;
		this.table = table;
		this.colums = colums;
		this.restriction = restriction;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTable() {
		return table;
	}

	public void setTable(String table) {
		this.table = table;
	}

	public LinkedList<Column> getColums() {
		return colums;
	}

	public void setColums(LinkedList<Column> colums) {
		this.colums = colums;
	}

	public LinkedList<Restiction> getRestriction() {
		return restriction;
	}

	public void setRestriction(LinkedList<Restiction> restriction) {
		this.restriction = restriction;
	}

}
