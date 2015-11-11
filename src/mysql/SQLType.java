package src.mysql;

public enum SQLType {
	CHAR, VARCHAR, LONGVARCHAR, NUMERIC, DECIMAL, BIT, TINYINT, SMALLINT, INTEGER, BIGINT, REAL, FLOAT, DOUBLE, BINARY, VARBINARY, LONGBINARY, DATE, TIME, TIMESTAMP;

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
		case INTEGER:
			return "INTEGER";
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
			return SQLType.INTEGER;
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
	
}
