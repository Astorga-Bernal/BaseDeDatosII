package src.mysql;

public enum Action {
	CASACADE, SET_NULL, SET_DEFAULT,RESTRICTED, NO_ACTION;

	@Override
	public String toString() {
		switch (this) {
		case CASACADE:
			return "CASACADE";
		case SET_NULL:
			return "SET_NULL";
		case SET_DEFAULT:
			return "SET_DEFAULT";
		case RESTRICTED:
			return "RESTRICTED";
		case NO_ACTION:
			return "NO_ACTION";
		}
		return null;
	}

	public static Action getAction(int typeAction){
		switch (typeAction) {
		case 0:
			return Action.CASACADE;
		case 1:
			return Action.SET_NULL;
		case 2:
			return Action.SET_DEFAULT;
		case 3:
			return Action.RESTRICTED;
		case 4:
			return Action.NO_ACTION;
		}
		return null;
	}
}
