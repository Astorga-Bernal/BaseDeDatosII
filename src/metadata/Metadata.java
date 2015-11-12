package src.metadata;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.LinkedList;

import src.DatabaseConnection;
import src.mysql.Action;
import src.mysql.ActionEvent;
import src.mysql.Column;
import src.mysql.ForeingKey;
import src.mysql.Index;
import src.mysql.PrimaryKey;
import src.mysql.Restiction;
import src.mysql.Table;
import src.mysql.Type;
import src.mysql.UniqueKey;
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
			ResultSet rs = databaseconnection.newMataData().getTables(null, schema,"%", types);
			while (rs.next()) {
				Table tabla = new Table();	
				tabla.setName(rs.getString(3)); 

				System.out.print("***Datos de Tabla***");System.out.print("\n"); 
				System.out.println("  catalogo: " + rs.getString(1));
				System.out.println("  esquema: " + rs.getString(2));
				System.out.println("  nombre: " + rs.getString(3));
				System.out.println("  tipo: " + rs.getString(4));
				System.out.println("  comentarios: " + rs.getString(5));

				ResultSet rsPrimaryKey = databaseconnection.newMataData().getPrimaryKeys(rs.getString(1), rs.getString(2), rs.getString(3));
				System.out.print("-Primary Keys: "); System.out.print("\n"); 
				while(rsPrimaryKey.next()) {
					Column columna = new Column();
					LinkedList<Column> columns = new LinkedList<Column>();
					System.out.print("  "+ rsPrimaryKey.getString("PK_NAME")); 
					System.out.print("  "+ rsPrimaryKey.getString("COLUMN_NAME")); 
					columna.setName(rsPrimaryKey.getString("COLUMN_NAME"));
					columns.add(columna);
					PrimaryKey primaryKey = new PrimaryKey(rsPrimaryKey.getString("PK_NAME"),columns);
					tabla.setPrimarykey(primaryKey);
				}

				ResultSet rsColumn = databaseconnection.newMataData().getColumns(rs.getString(1), rs.getString(2), rs.getString(3), "%");
				System.out.print("-Columnas: "); System.out.print("\n"); 
				while(rsColumn.next()) {
					LinkedList<Column> columns = new LinkedList<Column>();
					Column column = new Column();
					column.setName(rsColumn.getString("COLUMN_NAME"));System.out.print("  "+rsColumn.getString("COLUMN_NAME") );
					Type type = new Type(SQLType.getType(rsColumn.getInt("DATA_TYPE")),(rsColumn.getInt("COLUMN_SIZE")));	
					column.setType(type);
					column.setDefaultvalue(rsColumn.getString("COLUMN_DEF"));System.out.print("  "+rsColumn.getString("COLUMN_DEF") );
					if (rsColumn.getInt("NULLABLE") == 1) {
						column.setNullable(true);
						System.out.print("NULLABLE YES NULL");
					} else {
						column.setNullable(false);
						System.out.print("NULLABLE NOT NULL");
					}
					System.out.print("\n"); 
					columns.add(column);
					tabla.setColums(columns);
				}

				ResultSet rsIndexs = databaseconnection.newMataData().getIndexInfo(rs.getString(1), rs.getString(2), rs.getString(3), true, false);
				System.out.print("-Indexs: "); System.out.print("\n"); 
				while(rsIndexs.next()) {
					LinkedList<Column> columns = new LinkedList<Column>();
					LinkedList<Index> indexs = new LinkedList<Index>();
					Column column = new Column();
					column.setName(rsIndexs.getString("COLUMN_NAME"));
					columns.add(column);
					Index index = new Index(rsIndexs.getString("INDEX_NAME"),columns);
					indexs.add(index);
					tabla.setIndexs(indexs);
				}

				ResultSet rsForeingKey = databaseconnection.newMataData().getImportedKeys(rs.getString(1), rs.getString(2), rs.getString(3));
				System.out.print("-ForeingKey: "); System.out.print("\n"); 
				while(rsForeingKey.next()) {

					LinkedList<Column> columns = new LinkedList<Column>();
					Column column = new Column();
					column.setName(rsForeingKey.getString("FKCOLUMN_NAME"));
					columns.add(column);

					Restiction restriction = new Restiction();
					System.out.print("FKCOLUMN_NAME   " + rsForeingKey.getString("FKCOLUMN_NAME"));System.out.print("\n"); 

					System.out.print("UPDATE_RULE     " + rsForeingKey.getShort(("UPDATE_RULE")));System.out.print("\n"); 
					ActionEvent.getActionActionEvent(rsForeingKey.getShort(("UPDATE_RULE")));

					System.out.print("DELETE_RULE     " + rsForeingKey.getShort("DELETE_RULE"));System.out.print("\n"); 
					restriction.setAction(Action.getAction(rsForeingKey.getShort("DELETE_RULE")));

					LinkedList<ForeingKey> foreingkeys = new LinkedList<ForeingKey>();
					ForeingKey foreingKey = new ForeingKey(rsForeingKey.getString("FK_NAME"), columns, restriction);
					foreingkeys.add(foreingKey);

					tabla.setForeingkeys(foreingkeys);
				}

				ResultSet rsUniqueKey = databaseconnection.newMataData().getIndexInfo(rs.getString(1), rs.getString(2), rs.getString(3), true, false);
				System.out.print("-Uniquekeys: "); System.out.print("\n"); 
				while(rsUniqueKey.next()) {
					
					System.out.print(rsUniqueKey.getString("COLUMN_NAME"));
					LinkedList<Column> columns = new LinkedList<Column>();
					Column column = new Column();
					column.setName(rsUniqueKey.getString("COLUMN_NAME"));
					columns.add(column);
					
					System.out.print(rsUniqueKey.getString("INDEX_NAME"));
					LinkedList<UniqueKey> uniqueKeys = new LinkedList<UniqueKey>();
					UniqueKey uniqueKey = new UniqueKey(rsUniqueKey.getString("INDEX_NAME"),columns);
					uniqueKeys.add(uniqueKey);
					
					tabla.setUniquekeys(uniqueKeys);
				}
				
				tables.add(tabla); 
				System.out.print("\n"); 
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


	//	tabla.setName(rst.getString(3)); //Nombre
	//	tabla.setColums(getColums(tabla.getName())); //Columnas
	//	tabla.setPrimarykey(getStprimaryKey(tabla.getName())); //Primary Key
	//	tabla.setIndexs(getIndex(tabla.getName())); //Indexs

}
