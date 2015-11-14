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

	public static Timing getType(String type) {
		switch (type) {
		case "AFTER":
			return Timing.AFTER;
		case "BEFORE":
			return Timing.BEFORE;
		}
		return null;
	}

}