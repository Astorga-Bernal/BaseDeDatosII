package src.mysql;

import java.util.LinkedList;

public class ForeingKey {

	private String name;
	private LinkedList<Column> colums;
	private Restiction restriction;

	public ForeingKey() {
		super();
	}

	public ForeingKey(String name, LinkedList<Column> colums, Restiction restriction) {
		super();
		this.name = name;
		this.colums = colums;
		this.restriction = restriction;
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

	public Restiction getRestriction() {
		return restriction;
	}

	public void setRestriction(Restiction restriction) {
		this.restriction = restriction;
	}

}
