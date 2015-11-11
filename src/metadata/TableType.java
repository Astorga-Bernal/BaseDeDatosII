package src.metadata;

public enum TableType {
	TABLE, VIEW, SYSTEM_TABLE, GLOBAL_TEMPORARY, LOCAL_TEMPORARY, ALIAS, SYNONYM;

	@Override
	public String toString() {
		switch (this) {
		case TABLE:
			return "TABLE";
		case VIEW:
			return "VIEW";
		case SYSTEM_TABLE:
			return "SYSTEM_TABLE";
		case GLOBAL_TEMPORARY:
			return "GLOBAL TEMPORARY";
		case LOCAL_TEMPORARY:
			return "LOCAL TEMPORARY";
		case ALIAS:
			return "ALIAS";
		case SYNONYM:
			return "SYNONYM";
		}
		return null;
	}

}
