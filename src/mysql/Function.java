package src.mysql;

import java.util.LinkedList;

public class Function {

	private String name;
	private Type returntype;
	private LinkedList<FunctionParameter> parameters;
	private String code;

	public Function() {
		super();
	}

	public Function(String name, Type returntype, LinkedList<FunctionParameter> parameters, String code) {
		super();
		this.name = name;
		this.returntype = returntype;
		this.parameters = parameters;
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Type getReturntype() {
		return returntype;
	}

	public void setReturntype(Type returntype) {
		this.returntype = returntype;
	}

	public LinkedList<FunctionParameter> getParameters() {
		return parameters;
	}

	public void setParameters(LinkedList<FunctionParameter> parameters) {
		this.parameters = parameters;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public boolean equals(Function function){
		boolean eq = true;
		eq &= name.equals(function.getName());
		eq &= returntype.equals(function.getReturntype());
		eq &= code.equals(function.getCode());

		boolean eqParam = false;
		for (FunctionParameter c1 : parameters) {
			eqParam = false;
			for (FunctionParameter c2 : function.getParameters()) {
				if (c1.equals(c2)) {
					eqParam = true;
					break;
				}
			}
			if(!eqParam)
				break;
		}

		eq &= eqParam || (parameters.isEmpty() && function.getParameters().isEmpty());
		return eq;
	}
	
	public boolean equalsNameFunction(Function function){
		boolean eq = true;
		eq &= name.equals(function.getName());
		return eq;
	}
}