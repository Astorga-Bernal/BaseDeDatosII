package src.mysql;

import java.util.LinkedList;

public class Schema {

	private String name;
	private LinkedList<Table> tables;
	private LinkedList<View> views;
	private LinkedList<Function> functions;
	private LinkedList<StoredProcedure> storeprocedures;

	public Schema() {
		super();
	}

	public Schema(String name, LinkedList<Table> tables, LinkedList<View> views, LinkedList<Function> functions,
			LinkedList<StoredProcedure> storeprocedures) {
		super();
		this.name = name;
		this.tables = tables;
		this.views = views;
		this.functions = functions;
		this.storeprocedures = storeprocedures;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LinkedList<Table> getTables() {
		return tables;
	}

	public void setTables(LinkedList<Table> tables) {
		this.tables = tables;
	}

	public LinkedList<View> getViews() {
		return views;
	}

	public void setViews(LinkedList<View> views) {
		this.views = views;
	}

	public LinkedList<Function> getFunctions() {
		return functions;
	}

	public void setFunctions(LinkedList<Function> functions) {
		this.functions = functions;
	}

	public LinkedList<StoredProcedure> getStoreprocedures() {
		return storeprocedures;
	}

	public void setStoreprocedures(LinkedList<StoredProcedure> storeprocedures) {
		this.storeprocedures = storeprocedures;
	}

}