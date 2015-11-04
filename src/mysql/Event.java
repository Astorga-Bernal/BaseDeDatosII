package src.mysql;

public enum Event {
		INSERT, DELETE, UPDATE;

		@Override
		public String toString() {
			switch (this) {
			case INSERT:
				return "INSERT";
			case DELETE:
				return "DELETE";
			case UPDATE:
				return "UPDATE";
			}
			return null;
		}

}