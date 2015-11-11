package src.metadata;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import src.DatabaseConnection;
import src.mysql.Action;
import src.mysql.ActionEvent;
import src.mysql.Column;
import src.mysql.ForeingKey;
import src.mysql.Index;
import src.mysql.PrimaryKey;
import src.mysql.Restiction;
import src.mysql.SQLType;
import src.mysql.Schema;
import src.mysql.Table;
import src.mysql.Trigger;
import src.mysql.Type;
import src.mysql.UniqueKey;

public class Metadata {

	private Schema schema;
	private DatabaseConnection databaseconnection;

	public Metadata() {
	}

	public Metadata(String schema, DatabaseConnection databaseconnection) {
		super();
		this.schema = new Schema();
		this.schema.setName(schema);
		this.databaseconnection = databaseconnection;
	}

	public Schema getSchema() {
		return schema;
	}

	public void setSchema(Schema schema) {
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
			ResultSet rst = databaseconnection.newMataData().getTables(null, schema.getName(),"%", types);
			while (rst.next()) {
				Table tabla = new Table();
				tabla.setName(rst.getString("TABLE_NAME")); //Nombre
				tabla.setColums(getColums(tabla)); //Columnas
				tabla.setPrimarykey(getStprimaryKey(tabla)); //Primary Key
				tabla.setIndexs(getIndexs(tabla)); //Indexs
				tabla.setForeingkeys(getForeinKeys(tabla)); //Foreing Keys
				tabla.setUniquekeys(getUniqueKeys(tabla)); //Unique Keys
				tabla.setTrigges(getTriggers(tabla)); //Triggers
				tables.add(tabla);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tables;
	}
	
	private LinkedList<Trigger> getTriggers(Table tabla) {
		LinkedList<Trigger> triggers = new LinkedList<Trigger>();
		//TODO todos los trigers de una tabla
		return triggers;
	}

	private LinkedList<UniqueKey> getUniqueKeys(Table tabla) {
		LinkedList<UniqueKey> uniquekeys = new LinkedList<UniqueKey>();
		//TODO todas las claves unicas de una tabla
		return uniquekeys;
	}

	private LinkedList<ForeingKey> getForeinKeys(Table tabla) {
		LinkedList<ForeingKey> foreingkeys = new LinkedList<ForeingKey>();
		try {
			ResultSet rsc = databaseconnection.newMataData().getImportedKeys(null, schema.getName(), tabla.getName());
			while(rsc.next()){
				ForeingKey foreingkey = new ForeingKey();
				foreingkey.setName(rsc.getString("FK_NAME"));
				LinkedList<Column> columns = new LinkedList<Column>();
				String tabla_name = rsc.getString("FKTABLE_NAME");
				foreingkey.setTable(tabla_name);
				String column_name = rsc.getString("FKCOLUMN_NAME");
				ResultSet rsaux = databaseconnection.newMataData().getColumns(null, schema.getName(), tabla_name, column_name);
				while(rsaux.next()){
	 				Column columna = new Column();
					columna.setName(rsaux.getString("COLUMN_NAME"));
					Type type = new Type(SQLType.getType(rsaux.getInt("DATA_TYPE")), Integer.valueOf(rsaux.getInt("COLUMN_SIZE")));	
					columna.setType(type);
					columna.setDefaultvalue(rsaux.getString("COLUMN_DEF"));
					if(rsaux.getInt("NULLABLE")==1) //0 = NOT NULL 1= NULLEABLE
						columna.setNullable(true);
					columns.add(columna);
				}
				foreingkey.setColums(columns);

				LinkedList<Restiction> restrictions = new LinkedList<Restiction>();
				Restiction update_restriction =  new Restiction();
				update_restriction.setEvent(ActionEvent.UPDATE);
				update_restriction.setAction(Action.getType(rsc.getShort("UPDATE_RULE")));
				restrictions.add(update_restriction);
				Restiction delete_restriction =  new Restiction();
				delete_restriction.setEvent(ActionEvent.DELETE);
				delete_restriction.setAction(Action.getType(rsc.getShort("DELETE_RULE")));
				restrictions.add(delete_restriction);				
				foreingkey.setRestriction(restrictions);
				
				foreingkeys.add(foreingkey);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return foreingkeys;
	}

	private LinkedList<Index> getIndexs(Table tabla) {
		LinkedList<Index> indexs = new LinkedList<Index>();
		try {
			ResultSet rsc = databaseconnection.newMataData().getIndexInfo(null, schema.getName(), tabla.getName(), false, false);
			while(rsc.next()){
				Index index = new Index();
				index.setName(rsc.getString("INDEX_NAME"));
				LinkedList<Column> columns = new LinkedList<Column>();
				String columname = rsc.getString("COLUMN_NAME");
				for(Column c: tabla.getColums()){
					if(c.getName().equals(columname))
						columns.add(c);
				}
				index.setColums(columns);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return indexs;
	}

	private PrimaryKey getStprimaryKey(Table tabla) {
		PrimaryKey primaryKey = new PrimaryKey();
		try {
			ResultSet rsc = databaseconnection.newMataData().getPrimaryKeys(null, schema.getName(), tabla.getName());
			while(rsc.next()){
				primaryKey.setName(rsc.getString("PK_NAME"));
				LinkedList<Column> columns = new LinkedList<Column>();
				String columname = rsc.getString("COLUMN_NAME");
				for(Column c: tabla.getColums()){
					if(c.getName().equals(columname))
						columns.add(c);
				}
				primaryKey.setColums(columns);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return primaryKey;
	}

	public LinkedList<Column> getColums(Table tabla) {
		LinkedList<Column> columns = new LinkedList<Column>();
		try {
			ResultSet rsc = databaseconnection.newMataData().getColumns(null, schema.getName(), tabla.getName(), "%");
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
