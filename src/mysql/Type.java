package src.mysql;

public class Type {

	private SQLType type;
	private Integer length;

	public Type() {
		super();
	}

	public Type(SQLType type, Integer length) {
		super();
		this.type = type;
		this.length = length;
	}

	public SQLType getType() {
		return type;
	}

	public void setType(SQLType type) {
		this.type = type;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

}
