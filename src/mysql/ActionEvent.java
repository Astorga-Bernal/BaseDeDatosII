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

}
