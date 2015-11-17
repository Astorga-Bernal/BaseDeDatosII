package src.metadata;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import src.DatabaseConnection;
import src.mysql.Action;
import src.mysql.ActionEvent;
import src.mysql.Column;
import src.mysql.Event;
import src.mysql.ForeingKey;
import src.mysql.Function;
import src.mysql.Index;
import src.mysql.ParameterType;
import src.mysql.FunctionParameter;
import src.mysql.PrimaryKey;
import src.mysql.ProcedureParameter;
import src.mysql.Restiction;
import src.mysql.SQLType;
import src.mysql.Schema;
import src.mysql.StoredProcedure;
import src.mysql.Table;
import src.mysql.Timing;
import src.mysql.Trigger;
import src.mysql.Type;
import src.mysql.UniqueKey;
import src.mysql.View;

public class Metadata {

	private Schema schema;
	private DatabaseConnection databaseconnection;

	public Metadata() {
	}

	public Metadata(String schema, DatabaseConnection databaseconnection) {
		super();
		this.schema = new Schema();
		this.databaseconnection = databaseconnection;
		this.schema.setName(schema);
		this.schema.setTables(getTables());
		this.schema.setFunctions(getFunctions());
		this.schema.setStoreprocedures(getStoreProcedures());
		this.schema.setViews(getViews());
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

	private LinkedList<View> getViews() {
		LinkedList<View> views = new LinkedList<View>();
		String[] types = { TableType.VIEW.toString() };
		try {
			ResultSet rst = databaseconnection.newMataData().getTables(null, schema.getName(), "%", types);
			while (rst.next()) {
				View view = new View();
				view.setName(rst.getString("TABLE_NAME"));
				ResultSet rsaux = databaseconnection.NewStatement()
						.executeQuery("SELECT * FROM information_schema.VIEWS v WHERE v.TABLE_NAME='" + view.getName()
								+ "' and v.TABLE_SCHEMA='" + schema.getName() + "';");
				if (rsaux.next())
					view.setQuery(rsaux.getString("VIEW_DEFINITION"));
				views.add(view);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return views;
	}

	private LinkedList<StoredProcedure> getStoreProcedures() {
		LinkedList<StoredProcedure> storeproductions = new LinkedList<StoredProcedure>();
		try {
			ResultSet rst = databaseconnection.NewStatement()
					.executeQuery("SELECT * FROM information_schema.ROUTINES r WHERE r.ROUTINE_SCHEMA='"+schema.getName()+"' AND r.ROUTINE_TYPE='PROCEDURE';");
			while (rst.next()) {
				StoredProcedure storeprocedure = new StoredProcedure();
				storeprocedure.setName(rst.getString("ROUTINE_NAME"));
				ResultSet rsaux = databaseconnection.NewStatement()
						.executeQuery("SELECT * FROM information_schema.ROUTINES r WHERE r.ROUTINE_SCHEMA='"
								+ schema.getName() + "' AND r.ROUTINE_NAME='" + storeprocedure.getName()
								+ "' AND r.ROUTINE_TYPE='PROCEDURE';");
				if (rsaux.next()) {
					storeprocedure.setCode(rsaux.getString("ROUTINE_DEFINITION"));
					ResultSet rsaux2 = databaseconnection.NewStatement()
							.executeQuery("SELECT * FROM information_schema.PARAMETERS p where p.SPECIFIC_NAME='"
									+ storeprocedure.getName() + "' and p.SPECIFIC_SCHEMA='" + schema.getName()
									+ "';");
					LinkedList<ProcedureParameter> parameters = new LinkedList<ProcedureParameter>();
					while (rsaux2.next()) {
						ProcedureParameter parameter = new ProcedureParameter();
						parameter.setName(rsaux2.getString("PARAMETER_NAME"));
						Type typep = new Type(SQLType.getType(rsaux2.getString("DATA_TYPE").toUpperCase()),
								Integer.valueOf(rsaux2.getInt("CHARACTER_MAXIMUM_LENGTH")));
						parameter.setType(typep);
						ParameterType typep2 = ParameterType.getType(rsaux2.getString("PARAMETER_MODE").toUpperCase());
						parameter.setParameterType(typep2);
						parameters.add(parameter);
					}
					storeprocedure.setParameters(parameters);
					storeproductions.add(storeprocedure);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return storeproductions;
	}

	private LinkedList<Function> getFunctions() {
		LinkedList<Function> functions = new LinkedList<Function>();
		try {
			ResultSet rst = databaseconnection.newMataData().getFunctions(null, schema.getName(), "%");
			while (rst.next()) {
				Function function = new Function();
				function.setName(rst.getString("FUNCTION_NAME"));
				ResultSet rsaux = databaseconnection.NewStatement()
						.executeQuery("SELECT * FROM information_schema.ROUTINES r WHERE r.ROUTINE_SCHEMA='"
								+ schema.getName() + "' AND r.ROUTINE_NAME='" + function.getName()
								+ "' AND r.ROUTINE_TYPE='FUNCTION';");
				if (rsaux.next()) {
					function.setCode(rsaux.getString("ROUTINE_DEFINITION"));
					Type type = new Type(SQLType.getType(rsaux.getString("DATA_TYPE").toUpperCase()),
							Integer.valueOf(rsaux.getInt("CHARACTER_MAXIMUM_LENGTH")));
					function.setReturntype(type);
					ResultSet rsaux2 = databaseconnection.NewStatement()
							.executeQuery("SELECT * FROM information_schema.PARAMETERS p where p.SPECIFIC_NAME='"
									+ function.getName() + "' and p.SPECIFIC_SCHEMA='" + schema.getName()
									+ "' and PARAMETER_MODE='IN';");
					LinkedList<FunctionParameter> parameters = new LinkedList<FunctionParameter>();
					while (rsaux2.next()) {
						FunctionParameter parameter = new FunctionParameter();
						parameter.setName(rsaux2.getString("PARAMETER_NAME"));
						Type typep = new Type(SQLType.getType(rsaux2.getString("DATA_TYPE").toUpperCase()),
								Integer.valueOf(rsaux2.getInt("CHARACTER_MAXIMUM_LENGTH")));
						parameter.setType(typep);
						parameters.add(parameter);
					}
					function.setParameters(parameters);
					functions.add(function);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return functions;
	}

	public LinkedList<Table> getTables() {
		LinkedList<Table> tables = new LinkedList<Table>();
		String[] types = { TableType.TABLE.toString() };
		try {
			ResultSet rst = databaseconnection.newMataData().getTables(null, schema.getName(), "%", types);
			while (rst.next()) {
				Table tabla = new Table();
				tabla.setName(rst.getString("TABLE_NAME")); // Nombre
				tabla.setColums(getColums(tabla)); // Columnas
				tabla.setPrimarykey(getStprimaryKey(tabla)); // Primary Key
				tabla.setIndexs(getIndexs(tabla)); // Indexs
				tabla.setForeingkeys(getForeinKeys(tabla)); // Foreing Keys
				tabla.setTrigges(getTriggers(tabla)); // Triggers
				tabla.setUniquekeys(getUniqueKeys(tabla)); // Unique Keys
				tables.add(tabla);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tables;
	}

	private LinkedList<Trigger> getTriggers(Table tabla) {
		LinkedList<Trigger> triggers = new LinkedList<Trigger>();
		try {
			ResultSet rsc = databaseconnection.NewStatement()
					.executeQuery("select * from information_schema.TRIGGERS t WHERE t.TRIGGER_SCHEMA='"
							+ schema.getName() + "' and t.EVENT_OBJECT_TABLE='" + tabla.getName() + "';");
			while (rsc.next()) {
				Trigger trigger = new Trigger();
				trigger.setName(rsc.getString("TRIGGER_NAME"));
				trigger.setCode(rsc.getString("ACTION_STATEMENT"));
				trigger.setEvent(Event.getType(rsc.getString("EVENT_MANIPULATION")));
				trigger.setTiming(Timing.getType(rsc.getString("ACTION_TIMING")));

				triggers.add(trigger);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return triggers;
	}

	private LinkedList<UniqueKey> getUniqueKeys(Table tabla) {
		LinkedList<UniqueKey> uniquekeys = new LinkedList<UniqueKey>();
		try {
			ResultSet rsc = databaseconnection.NewStatement().executeQuery(
					"SELECT * FROM INFORMATION_SCHEMA.TABLE_CONSTRAINTS it WHERE it.CONSTRAINT_TYPE = 'UNIQUE' and it.TABLE_SCHEMA = '"
							+ schema.getName() + "' and it.TABLE_NAME='" + tabla.getName() + "'");
			while (rsc.next()) {
				UniqueKey uniquekey = new UniqueKey();
				uniquekey.setName(rsc.getString("CONSTRAINT_NAME"));
				ResultSet rsaux = databaseconnection.NewStatement()
						.executeQuery("SELECT * FROM information_schema.key_column_usage k WHERE k.table_schema = '"
								+ schema.getName() + "' and k.table_name = '" + tabla.getName()
								+ "' and k.CONSTRAINT_NAME='" + uniquekey.getName() + "'");
				LinkedList<Column> columnas = new LinkedList<Column>();
				while (rsaux.next()) {
					for (Column c : tabla.getColums()) {
						if (c.getName().equals(rsaux.getString("COLUMN_NAME"))) {
							columnas.add(c);
							break;
						}
					}
				}
				uniquekey.setColums(columnas);
				uniquekeys.add(uniquekey);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return uniquekeys;
	}

	private LinkedList<ForeingKey> getForeinKeys(Table tabla) {
		LinkedList<ForeingKey> foreingkeys = new LinkedList<ForeingKey>();
		try {
			ResultSet rsc = databaseconnection.newMataData().getImportedKeys(null, schema.getName(), tabla.getName());
			while (rsc.next()) {
				ForeingKey foreingkey = new ForeingKey();
				foreingkey.setName(rsc.getString("FK_NAME"));
				LinkedList<Column> columns = new LinkedList<Column>();
				String tabla_name = rsc.getString("FKTABLE_NAME");
				foreingkey.setTable(tabla_name);
				String column_name = rsc.getString("FKCOLUMN_NAME");
				ResultSet rsaux = databaseconnection.newMataData().getColumns(null, schema.getName(), tabla_name,
						column_name);
				while (rsaux.next()) {
					Column columna = new Column();
					columna.setName(rsaux.getString("COLUMN_NAME"));
					Type type = new Type(SQLType.getType(rsaux.getInt("DATA_TYPE")),
							Integer.valueOf(rsaux.getInt("COLUMN_SIZE")));
					columna.setType(type);
					columna.setDefaultvalue(rsaux.getString("COLUMN_DEF"));
					if (rsaux.getInt("NULLABLE") == 1) // 0 = NOT NULL 1=
														// NULLEABLE
						columna.setNullable(true);
					columns.add(columna);
				}
				foreingkey.setColums(columns);

				LinkedList<Restiction> restrictions = new LinkedList<Restiction>();
				Restiction update_restriction = new Restiction();
				update_restriction.setEvent(ActionEvent.UPDATE);
				update_restriction.setAction(Action.getType(rsc.getShort("UPDATE_RULE")));
				restrictions.add(update_restriction);
				Restiction delete_restriction = new Restiction();
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
			ResultSet rsc = databaseconnection.newMataData().getIndexInfo(null, schema.getName(), tabla.getName(),
					false, false);
			while (rsc.next()) {
				Index index = new Index();
				index.setName(rsc.getString("INDEX_NAME"));
				LinkedList<Column> columns = new LinkedList<Column>();
				String columname = rsc.getString("COLUMN_NAME");
				for (Column c : tabla.getColums()) {
					if (c.getName().equals(columname))
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
		try {
			ResultSet rsc = databaseconnection.newMataData().getPrimaryKeys(null, schema.getName(), tabla.getName());
			if (rsc.next()) {
				PrimaryKey primaryKey = new PrimaryKey();
				primaryKey.setName(rsc.getString("PK_NAME"));
				LinkedList<Column> columns = new LinkedList<Column>();
				String columname = rsc.getString("COLUMN_NAME");
				for (Column c : tabla.getColums()) {
					if (c.getName().equals(columname))
						columns.add(c);
				}
				primaryKey.setColums(columns);
				return primaryKey;
		
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public LinkedList<Column> getColums(Table tabla) {
		LinkedList<Column> columns = new LinkedList<Column>();
		try {
			ResultSet rsc = databaseconnection.newMataData().getColumns(null, schema.getName(), tabla.getName(), "%");
			while (rsc.next()) {
				Column columna = new Column();
				columna.setName(rsc.getString("COLUMN_NAME"));
				Type type = new Type(SQLType.getType(rsc.getInt("DATA_TYPE")),
						Integer.valueOf(rsc.getInt("COLUMN_SIZE")));
				columna.setType(type);
				columna.setDefaultvalue(rsc.getString("COLUMN_DEF"));
				if (rsc.getInt("NULLABLE") == 1) // 0 = NOT NULL 1= NULLEABLE
					columna.setNullable(true);
				columns.add(columna);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return columns;
	}

}
