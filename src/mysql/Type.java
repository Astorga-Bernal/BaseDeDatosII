package src.mysql;

public class Type {

	private SQLType sqltype;
	private Integer length;

	public Type() {
		super();
	}

	public Type(SQLType type, Integer length) {
		super();
		this.sqltype = type;
		this.length = length;
	}

	public SQLType getSQLType() {
		return sqltype;
	}

	public void setSQLType(SQLType type) {
		this.sqltype = type;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}
	
	public boolean equals(Type type){
		boolean eq = true;
		eq &= length.equals(type.getLength());
		eq &= sqltype.equals(type.getSQLType());
		return eq;
	}

	public String toString(){
		if(length>0)
			return sqltype.toString()+"("+length+")";
		else
			return sqltype.toString();
	}
}
