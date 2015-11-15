package src.mysql;

public enum SQLType {
	CHAR, VARCHAR, LONGVARCHAR, NUMERIC, DECIMAL, BIT, TINYINT, SMALLINT, INT,INTEGER, BIGINT, REAL, FLOAT, DOUBLE, BINARY, VARBINARY, LONGBINARY, DATE, TIME, TIMESTAMP;

	@Override
	public String toString() {
		switch (this) {
		case CHAR:
			return "CHAR";
		case VARCHAR:
			return "VARCHAR";
		case LONGVARCHAR:
			return "LONGVARCHAR";
		case NUMERIC:
			return "NUMERIC";
		case DECIMAL:
			return "DECIMAL";
		case BIT:
			return "BIT";
		case TINYINT:
			return "TINYINT";
		case SMALLINT:
			return "SMALLINT";
		case INT:
			return "INT";
		case INTEGER:
			return "INT";
		case BIGINT:
			return "BIGINT";
		case REAL:
			return "REAL";
		case FLOAT:
			return "FLOAT";
		case DOUBLE:
			return "DOUBLE";
		case BINARY:
			return "BINARY";
		case VARBINARY:
			return "VARBINARY";
		case LONGBINARY:
			return "LONGBINARY";
		case DATE:
			return "DATE";
		case TIME:
			return "TIME";
		case TIMESTAMP:
			return "TIMESTAMP";
		}

		return null;
	}

	public static SQLType getType(int type){
		switch (type) {
		case 1:
			return SQLType.CHAR;
		case 12:
			return SQLType.VARCHAR;
		case -1:
			return SQLType.LONGVARCHAR;
		case 2:
			return SQLType.NUMERIC;
		case 3:
			return SQLType.DECIMAL;
		case -7:
			return SQLType.BIT;
		case -6:
			return SQLType.TINYINT;
		case 5:
			return SQLType.SMALLINT;
		case 4:
			return SQLType.INT;
		case -5:
			return SQLType.BIGINT;
		case 7:
			return SQLType.REAL;
		case 6:
			return SQLType.FLOAT;
		case 8:
			return SQLType.DOUBLE;
		case -2:
			return SQLType.BINARY;
		case -3:
			return SQLType.VARBINARY;
		case -4:
			return SQLType.LONGBINARY;
		case 91:
			return SQLType.DATE;
		case 92:
			return SQLType.TIME;
		case 93:
			return SQLType.TIMESTAMP;
		}

		return null;
	}
	
	public static SQLType getType(String type){
		switch (type) {
		case "CHAR":
			return SQLType.CHAR;
		case "VARCHAR":
			return SQLType.VARCHAR;
		case "LONGVARCHAR":
			return SQLType.LONGVARCHAR;
		case "NUMERIC":
			return SQLType.NUMERIC;
		case "DECIMAL":
			return SQLType.DECIMAL;
		case "BIT":
			return SQLType.BIT;
		case "TINYINT":
			return SQLType.TINYINT;
		case "SMALLINT":
			return SQLType.SMALLINT;
		case "INTEGER":
			return SQLType.INT;
		case "INT":
			return SQLType.INT;
		case "BIGINT":
			return SQLType.BIGINT;
		case "REAL":
			return SQLType.REAL;
		case "FLOAT":
			return SQLType.FLOAT;
		case "DOUBLE":
			return SQLType.DOUBLE;
		case "BINARY":
			return SQLType.BINARY;
		case "VARBINARY":
			return SQLType.VARBINARY;
		case "LONGBINARY":
			return SQLType.LONGBINARY;
		case "DATE":
			return SQLType.DATE;
		case "TIME":
			return SQLType.TIME;
		case "TIMESTAMP":
			return SQLType.TIMESTAMP;
		}

		return null;
	}

	public boolean equals(SQLType sqlType){
		return (this.toString().equals(sqlType.toString()));
	}
}
