package src.mysql;

import java.util.LinkedList;

public class Table {

	private String name;
	private PrimaryKey primarykey;
	private LinkedList<Column> colums;
	private LinkedList<Index> indexs;
	private LinkedList<ForeingKey> foreingkeys;
	private LinkedList<UniqueKey> uniquekeys;
	private LinkedList<Trigger> trigges;

	public Table() {
		super();
	}

	public Table(String name, PrimaryKey primarykey, LinkedList<Column> colums, LinkedList<Index> indexs,
			LinkedList<ForeingKey> foreingkeys, LinkedList<UniqueKey> uniquekeys, LinkedList<Trigger> trigges) {
		super();
		this.name = name;
		this.primarykey = primarykey;
		this.colums = colums;
		this.indexs = indexs;
		this.foreingkeys = foreingkeys;
		this.uniquekeys = uniquekeys;
		this.trigges = trigges;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PrimaryKey getPrimarykey() {
		return primarykey;
	}

	public void setPrimarykey(PrimaryKey primarykey) {
		this.primarykey = primarykey;
	}

	public LinkedList<Column> getColums() {
		return colums;
	}

	public void setColums(LinkedList<Column> colums) {
		this.colums = colums;
	}

	public LinkedList<Index> getIndexs() {
		return indexs;
	}

	public void setIndexs(LinkedList<Index> indexs) {
		this.indexs = indexs;
	}

	public LinkedList<ForeingKey> getForeingkeys() {
		return foreingkeys;
	}

	public void setForeingkeys(LinkedList<ForeingKey> foreingkeys) {
		this.foreingkeys = foreingkeys;
	}

	public LinkedList<UniqueKey> getUniquekeys() {
		return uniquekeys;
	}

	public void setUniquekeys(LinkedList<UniqueKey> uniquekeys) {
		this.uniquekeys = uniquekeys;
	}

	public LinkedList<Trigger> getTrigges() {
		return trigges;
	}

	public void setTrigges(LinkedList<Trigger> trigges) {
		this.trigges = trigges;
	}

	public boolean equals(Table tabla) {
		boolean eq = true;
		eq &= name.equals(tabla.getName());
		boolean eqColum = false;
		for (Column c1 : colums) {
			eqColum = false;
			for (Column c2 : tabla.getColums()) {
				if (c1.equals(c2)) {
					eqColum = true;
					break;
				}
			}
			if(!eqColum)
				return false;
		}
		eq &= eqColum || (colums.isEmpty() && tabla.getColums().isEmpty());
		if(primarykey!=null)
			eq &= primarykey.equals(tabla.getPrimarykey());
		
		boolean eqIndex = false;
		for (Index i1 : indexs) {
			eqIndex = false;
			for (Index i2 : tabla.getIndexs()) {
				if (i1.equals(i2)) {
					eqIndex = true;
					break;
				}
			}
			if(!eqIndex)
				return false;
		}
		eq &= eqIndex || (indexs.isEmpty() && tabla.getIndexs().isEmpty());
		boolean eqForeingKeys = false;
		for (ForeingKey fk1 : foreingkeys) {
			eqForeingKeys = false;
			for (ForeingKey fk2 : tabla.getForeingkeys()) {
				if (fk1.equals(fk2)) {
					eqForeingKeys = true;
					break;
				}
			}
			if(!eqForeingKeys)
				return false;
		}
		eq &= eqForeingKeys || (foreingkeys.isEmpty() && tabla.getForeingkeys().isEmpty());
		boolean eqUniqueKeys = false;
		for (UniqueKey uk1 : uniquekeys) {
			eqUniqueKeys = false;
			for (UniqueKey uk2 : tabla.getUniquekeys()) {
				if (uk1.equals(uk2)) {
					eqUniqueKeys = true;
					break;
				}
			}
			if(!eqUniqueKeys)
				return false;
		}
		eq &= eqUniqueKeys || (uniquekeys.isEmpty() && tabla.getUniquekeys().isEmpty());
		boolean eqTriggers = false;
		for (Trigger t1 : trigges) {
			eqTriggers = false;
			for (Trigger t2 : tabla.getTrigges()) {
				if (t1.equals(t2)) {
					eqTriggers = true;
					break;
				}
			}
			if(!eqTriggers)
				return false;
		}
		return eq &= eqTriggers || (trigges.isEmpty() && tabla.getTrigges().isEmpty());
	}
}
