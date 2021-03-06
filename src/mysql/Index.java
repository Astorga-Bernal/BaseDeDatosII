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
	
	public boolean equals(Index index){
		boolean eq = true;
		eq &= name.equals(index.getName());
		eq &= colums.equals(index.getColums());
		return eq;
	}
	
	public boolean equalName(Index index){
		boolean eq = true;
		eq &= name.equals(index.getName());
		return eq;
	}
	
	public boolean equalColums(Index index){
		boolean eq = true;
		eq &= colums.equals(index.getColums());
		return eq;
	}
}
