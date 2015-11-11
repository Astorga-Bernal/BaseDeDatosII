package src.mysql;

public enum Action {
	CASACADE, SET_NULL, SET_DEFAULT, RESTRICTED, NO_ACTION;

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

	public static Action getType(Short type) {
		switch (type) {
		case 0:
			return Action.CASACADE;
		case 1:
			return Action.RESTRICTED;
		case 2:
			return Action.SET_NULL;
		case 3:
			return Action.NO_ACTION;
		case 4:
			return Action.SET_DEFAULT;
		}
		return null;
	}
}
