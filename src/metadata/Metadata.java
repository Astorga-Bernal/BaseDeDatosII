package src.metadata;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.LinkedList;

import src.DatabaseConnection;
import src.mysql.Column;
import src.mysql.Table;
import src.mysql.Type;
import src.mysql.SQLType;

public class Metadata {

	private String schema;
	private DatabaseConnection databaseconnection;

	public Metadata() {
		// TODO Auto-generated constructor stub
	}

	public Metadata(String schema, DatabaseConnection databaseconnection) {
		super();
		this.schema = schema;
		this.databaseconnection = databaseconnection;
	}

	public String getSchema() {
		return schema;
	}

	public void setSchema(String schema) {
		this.schema = schema;
	}

	public DatabaseConnection getDatabaseconnection() {
		return databaseconnection;
	}

	public void setDatabaseconnection(DatabaseConnection databaseconnection) {
		this.databaseconnection = databaseconnection;
	}

	public LinkedList<Table> getTables() {
		LinkedList<Table> tables = new LinkedList<Table>();
		String[] types = {TableType.TABLE.toString()};
		try {
			ResultSet rst = databaseconnection.newMataData().getTables(null, schema,"%", types);
			while (rst.next()) {
				Table tabla = new Table();
				tabla.setName(rst.getString(3)); //Nombre
				tabla.setColums(getColums(tabla.getName())); //Columnas
//				tabla.setPrimarykey(getStprimaryKey(tabla.getName())); //Primary Key
//				tabla.setIndexs(getIndex(tabla.getName())); //Indexs
				
				tables.add(tabla);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tables;
	}
	
	public LinkedList<Column> getColums(String table_name) {
		LinkedList<Column> columns = new LinkedList<Column>();
		try {
			ResultSet rsc = databaseconnection.newMataData().getColumns(null, schema, table_name, "%");
			while(rsc.next()){
 				Column columna = new Column();
				columna.setName(rsc.getString("COLUMN_NAME"));
				Type type = new Type(SQLType.getType(rsc.getInt("DATA_TYPE")), Integer.valueOf(rsc.getInt("COLUMN_SIZE")));	
				columna.setType(type);
				columna.setDefaultvalue(rsc.getString("COLUMN_DEF"));
				if(rsc.getInt("NULLABLE")==1) //0 = NOT NULL 1= NULLEABLE
					columna.setNullable(true);
				columns.add(columna);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return columns;
	}

}
