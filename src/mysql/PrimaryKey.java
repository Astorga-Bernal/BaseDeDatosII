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

	public boolean equals(PrimaryKey primaryKey){
		boolean eq = true;
		eq &= name.equals(primaryKey.getName());
		boolean eqColum = false;
		for (Column c1 : columns) {
			eqColum = false;
			for (Column c2 : primaryKey.getColums()) {
				if (c1.equals(c2)) {
					eqColum = true;
					break;
				}
			}
			if(!eqColum)
				break;
		}
		return eq &= eqColum || (columns.isEmpty() && primaryKey.getColums().isEmpty());
	}
}
