package src.mysql;

public class ProcedureParameter {
	private String name;
	private Type type;
	private ParameterType parameterType;

	public ProcedureParameter() {
		super();
	}

	public ProcedureParameter(String name, Type type, ParameterType parameterType) {
		super();
		this.name = name;
		this.type = type;
		this.parameterType = parameterType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public ParameterType getParameterType() {
		return parameterType;
	}

	public void setParameterType(ParameterType parameterType) {
		this.parameterType = parameterType;
	}

}