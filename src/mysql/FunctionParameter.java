package src.mysql;

public class FunctionParameter {

	private String name;
	private Type type;

	public FunctionParameter() {
		super();
	}

	public FunctionParameter(String name, Type type) {
		super();
		this.name = name;
		this.type = type;
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
	
	public boolean equals(FunctionParameter functionParameter) {
		boolean eq = true;
		eq &= name.equals(functionParameter.getName());
		eq &= type.equals(functionParameter.getType());
		return eq;
	}
}