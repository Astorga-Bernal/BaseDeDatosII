package src.mysql;

public enum Action {
	CASACADE, SET_NULL, SET_DEFAULT,RESTRICTED, NO_ACTION;

	@Override
	public String toString() {
		switch (this) {
		case CASACADE:
			return "CASACADE";
		case SET_NULL:
			return "SET NULL";
		case SET_DEFAULT:
			return "SET DEFAULT";
		case RESTRICTED:
			return "RESTRICTED";
		case NO_ACTION:
			return "NO ACTION";
		}
		return null;
	}
}
