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
		
		public static Event getType(String type){
			switch (type) {
			case "INSERT":
				return Event.INSERT;
			case "DELETE":
				return Event.DELETE;
			case "UPDATE":
				return Event.UPDATE;
			}

			return null;
		}

}