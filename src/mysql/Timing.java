package src.mysql;

public enum Timing {
	AFTER, BEFORE;

	@Override
	public String toString() {
		switch (this) {
		case AFTER:
			return "AFTER";
		case BEFORE:
			return "BEFORE";
		}
		return null;
	}

}