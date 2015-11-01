package src.mysql;

public class Column {

	private String name;
	private Type type;
	private String defaultvalue;
	private boolean nullable;

	public Column() {
		super();
	}

	public Column(String name, Type type, String defaultvalue, boolean nullable) {
		super();
		this.name = name;
		this.type = type;
		this.defaultvalue = defaultvalue;
		this.nullable = nullable;
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

	public String getDefaultvalue() {
		return defaultvalue;
	}

	public void setDefaultvalue(String defaultvalue) {
		this.defaultvalue = defaultvalue;
	}

	public boolean isNullable() {
		return nullable;
	}

	public void setNullable(boolean nullable) {
		this.nullable = nullable;
	}

}
