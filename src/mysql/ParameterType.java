package src.mysql;

public enum ParameterType {
	IN, OUT, INOUT;

	@Override
	public String toString() {
		switch (this) {
		case IN:
			return "IN";
		case OUT:
			return "OUT";
		case INOUT:
			return "INOUT";
		}
		return null;
	}

	public static ParameterType getType(String type) {
		switch (type) {
		case "IN":
			return ParameterType.IN;
		case "OUT":
			return ParameterType.OUT;
		case "INOUT":
			return ParameterType.INOUT;
		}

		return null;
	}

	public boolean equals(ParameterType parameterType) {
		return (this.toString().equals(parameterType.toString()));
	}
}