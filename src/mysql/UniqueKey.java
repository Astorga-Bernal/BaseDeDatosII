package src.mysql;

import java.util.LinkedList;

public class UniqueKey {
	
	private String name;
	private LinkedList<Column> colums;

	public UniqueKey() {
		super();
	}

	public UniqueKey(String name, LinkedList<Column> colums) {
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
	
	public boolean equals(UniqueKey uniqueKey){
		boolean eq = true;
		eq &= name.equals(uniqueKey.getName());
		boolean eqColum = false;
		for (Column c1 : colums) {
			eqColum = false;
			for (Column c2 : uniqueKey.getColums()) {
				if (c1.equals(c2)) {
					eqColum = true;
					break;
				}
			}
			if(!eqColum)
				break;
		}
		return eq &= eqColum || (colums.isEmpty() && uniqueKey.getColums().isEmpty());
	}
	
	public boolean equalName(UniqueKey uniqueKey){
		boolean eq = true;
		eq &= name.equals(uniqueKey.getName());
		return eq;
	}
	
	public boolean equalColumns(UniqueKey uniqueKey){
		boolean eq = true;
		boolean eqColum = false;
		for (Column c1 : colums) {
			eqColum = false;
			for (Column c2 : uniqueKey.getColums()) {
				if (c1.equals(c2)) {
					eqColum = true;
					break;
				}
			}
			if(!eqColum)
				break;
		}
		return eq &= eqColum || (colums.isEmpty() && uniqueKey.getColums().isEmpty());
	}
}
