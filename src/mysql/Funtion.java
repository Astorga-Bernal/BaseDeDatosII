package src.mysql;

import java.util.LinkedList;

public class Funtion {

	private String name;
	private Type returntype;
	private LinkedList<Parameter> parameters;
	private String code;

	public Funtion() {
		super();
	}

	public Funtion(String name, Type returntype, LinkedList<Parameter> parameters, String code) {
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

	public LinkedList<Parameter> getParameters() {
		return parameters;
	}

	public void setParameters(LinkedList<Parameter> parameters) {
		this.parameters = parameters;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}