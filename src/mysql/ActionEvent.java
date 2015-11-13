package src.mysql;

public enum ActionEvent {
	DELETE, UPDATE;

	@Override
	public String toString() {
		switch (this) {
		case DELETE:
			return "DELETE";
		case UPDATE:
			return "UPDATE";
		}
		return null;
	}

	public static ActionEvent getActionActionEvent(int typeActionEvent){
		switch (typeActionEvent) {
		case 0:
			return ActionEvent.DELETE;
		case 1:
			return ActionEvent.UPDATE;
		}
		return null;
	}
}