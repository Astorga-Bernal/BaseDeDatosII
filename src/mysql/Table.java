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
	
	public boolean equals(Table tabla){
		boolean eq = true;
		eq &= name.equals(tabla.getName());
		eq &= colums.equals(tabla.getColums());
		eq &= primarykey.equals(tabla.getPrimarykey());
		eq &= indexs.equals(tabla.getIndexs());
		eq &= foreingkeys.equals(tabla.getForeingkeys());
		eq &= uniquekeys.equals(tabla.getUniquekeys());
		eq &= trigges.equals(tabla.getTrigges());
		return eq;
	}
}
