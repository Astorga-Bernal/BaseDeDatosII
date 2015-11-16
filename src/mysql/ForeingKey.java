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
	
	public boolean equals(ForeingKey foreingKey){
		boolean eq = true;
		eq &= name.equals(foreingKey.getName());
		eq &= table.equals(foreingKey.getTable());
		boolean eqColum = false;
		for (Column c1 : colums) {
			eqColum = false;
			for (Column c2 : foreingKey.getColums()) {
				if (c1.equals(c2)) {
					eqColum = true;
					break;
				}
			}
			if(!eqColum)
				break;
		}
		eq &= eqColum || (colums.isEmpty() && foreingKey.getColums().isEmpty());
		boolean eqRestrictions = false;
		for (Restiction r1 : restriction) {
			eqRestrictions = false;
			for (Restiction r2 : foreingKey.getRestriction()) {
				if (r1.equals(r2)) {
					eqRestrictions = true;
					break;
				}
			}
			if(!eqRestrictions)
				break;
		}
		eq &= eqRestrictions || (restriction.isEmpty() && foreingKey.getRestriction().isEmpty());
		return eq;
	}
	
	public boolean equalName(ForeingKey foreingKey){
		boolean eq = true;
		eq &= name.equals(foreingKey.getName());
		return eq;
	}
	
	public boolean equalColums(ForeingKey foreingKey){
		boolean eq = true;
		boolean eqColum = false;
		for (Column c1 : colums) {
			eqColum = false;
			for (Column c2 : foreingKey.getColums()) {
				if (c1.equals(c2)) {
					eqColum = true;
					break;
				}
			}
			if(!eqColum)
				break;
		}
		eq &= eqColum || (colums.isEmpty() && foreingKey.getColums().isEmpty());
		return eq;
	}
	
	public boolean equalTable(ForeingKey foreingKey){
		boolean eq = true;
		eq &= table.equals(foreingKey.getTable());
		return eq;
	}
	
	public boolean equalRestriction(ForeingKey foreingKey){
		boolean eq = true;
		boolean eqRestrictions = false;
		for (Restiction r1 : restriction) {
			eqRestrictions = false;
			for (Restiction r2 : foreingKey.getRestriction()) {
				if (r1.equals(r2)) {
					eqRestrictions = true;
					break;
				}
			}
			if(!eqRestrictions)
				break;
		}
		eq &= eqRestrictions || (restriction.isEmpty() && foreingKey.getRestriction().isEmpty());
		return eq;
	}
	
}
