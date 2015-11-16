package src.mysql;

import java.util.LinkedList;

public class StoredProcedure {

	private String name;
	private LinkedList<ProcedureParameter> parameters;
	private String code;

	public StoredProcedure() {
		super();
	}

	public StoredProcedure(String name, LinkedList<ProcedureParameter> parameters, String code) {
		super();
		this.name = name;
		this.parameters = parameters;
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LinkedList<ProcedureParameter> getParameters() {
		return parameters;
	}

	public void setParameters(LinkedList<ProcedureParameter> parameters) {
		this.parameters = parameters;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public boolean equals(StoredProcedure storedProcedure){
		boolean eq = true;
		eq &= name.equals(storedProcedure.getName());
		eq &= code.equals(storedProcedure.getCode());

		boolean eqParam = false;
		for (ProcedureParameter p1 : parameters) {
			eqParam = false;
			for (ProcedureParameter p2 : storedProcedure.getParameters()) {
				if (p1.equals(p2)) {
					eqParam = true;
					break;
				}
			}
			if(!eqParam)
				break;
		}
		return eq &= eqParam || (parameters.isEmpty() && storedProcedure.getParameters().isEmpty());
	}
	
	public boolean equalsNameProcedure(StoredProcedure storedProcedure){
		boolean eq = true;
		eq &= name.equals(storedProcedure.getName());
		return eq;
	}
	
	public boolean equalsParam(StoredProcedure storedProcedure){
		boolean eq = true;
		boolean eqParam = false;
		for (ProcedureParameter p1 : parameters) {
			eqParam = false;
			for (ProcedureParameter p2 : storedProcedure.getParameters()) {
				if (p1.equals(p2)) {
					eqParam = true;
					break;
				}
			}
			if(!eqParam)
				break;
		}
		return eq &= eqParam || (parameters.isEmpty() && storedProcedure.getParameters().isEmpty());
	}

}
