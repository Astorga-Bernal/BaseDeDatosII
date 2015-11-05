package src.mysql;

public class Parameter {

	private String name;
	private Type type;

	public Parameter() {
		super();
	}

	public Parameter(String name, Type type) {
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

}