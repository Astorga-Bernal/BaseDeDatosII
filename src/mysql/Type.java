package src.mysql;

public enum Type {
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
}
