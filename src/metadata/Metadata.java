package src.metadata;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import com.mysql.jdbc.DatabaseMetaData;

import src.DatabaseConnection;
import src.mysql.Schema;
import src.mysql.Table;

public class Metadata {

	private  String schema;
	private String[] types = {"TABLE"};
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
		try {
			ResultSet rs = databaseconnection.newMataData().getTables(null, schema,"%", types);
			while (rs.next()) {
				Table tabla = new Table();
				tabla.setName(rs.getString(3));
				tables.add(tabla);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tables;
	}

}
