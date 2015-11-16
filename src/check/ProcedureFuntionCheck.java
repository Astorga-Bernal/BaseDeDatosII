package src.check;

import src.mysql.Schema;
import src.mysql.StoredProcedure;
import src.mysql.Function;;

public class ProcedureFuntionCheck {

	private Schema schemaA;
	private Schema schemaB;

	public ProcedureFuntionCheck(Schema schemaA, Schema schemaB) {
		super();
		this.schemaA = schemaA;
		this.schemaB = schemaB;
	}

	public void check() {
		System.out.println("\n");
		System.out.println("----------------- NIVEL PROCEDIMIENTOS/FUNCIONES -----------------");System.out.println("\n");

		// PROCEDIMIENTOS
		System.out.println(">> CHEQUEANDO PROCEDIMIENTOS DEL SCHEMA " + schemaA.getName() + " EN EL SCHEMA " + schemaB.getName());
		for (StoredProcedure p1:schemaA.getStoreprocedures() ){
			System.out.println("	chequeando procedimiento: " + p1.getName());
			boolean exist = false;
			for (StoredProcedure p2:schemaB.getStoreprocedures() ){
				if(p1.getName().equals(p2.getName())){
					exist = true;
					break;
				}
			}
			if (!exist) 
				System.out.println(" El procedimiento " + p1.getName() + " del schema " + schemaA.getName() + " no existe en el schema "+ schemaB.getName());
		}

		System.out.println("\n");
		System.out.println(">> CHEQUEANDO PROCEDIMIENTOS DEL SCHEMA " + schemaB.getName() + " EN EL SCHEMA " + schemaA.getName());
		for (StoredProcedure p1:schemaB.getStoreprocedures() ){
			System.out.println("	chequeando procedimiento: " + p1.getName());
			boolean exist = false;
			for (StoredProcedure p2:schemaA.getStoreprocedures() ){
				if(p1.getName().equals(p2.getName())){
					exist = true;
					break;
				}
			}
			if (!exist) 
				System.out.println(" El procedimiento " + p1.getName() + " del schema " + schemaB.getName() + " no existe en el schema "+ schemaA.getName());
		}

		System.out.println("\n");
		System.out.println(">> CHEQUEANDO PROCEDIMIENTO COMUNES EN AMBOS SCHEMAS");
		for (StoredProcedure p1:schemaA.getStoreprocedures() ){
			for (StoredProcedure p2:schemaB.getStoreprocedures() ){
				if(p1.equalsNameProcedure(p2)){
					System.out.println("	El procedimiento: " + p1.getName() + " esta en ambos schemas");
					System.out.println("		CHEQUEANDO DIFERENCIA EN LOS PERFILES");

					// Chequeo el nombre 
					if (p1.equalsNameProcedure(p2)){
						System.out.println("		El procedimiento: "+p1.getName()+ " del schema: "+ schemaA.getName() + " posee el mismo nombre que: "+p2.getName() + " del schema: "+ schemaB.getName());
					}else {
						System.out.println("		El procedimiento: "+p1.getName()+ " del schema: "+ schemaA.getName() + " no! posee el mismo nombre que: "+p2.getName() + " del schema: "+ schemaB.getName());
					}

					// Chequeo de los parametros 
					if (p1.equalsParam(p2)){
						System.out.println("		El procedimiento: "+p1.getName()+ " del schema: "+ schemaA.getName() + " posee los mismos parametros que: "+p2.getName() + " del schema: "+ schemaB.getName());
					}else {
						System.out.println("		El procedimiento: "+p1.getName()+ " del schema: "+ schemaA.getName() + " no! posee los mismos parametros que: "+p2.getName() + " del schema: "+ schemaB.getName());
					}
					
					// Chequeo el codigo 
					if (p1.equalsCode(p2)){
						System.out.println("		El procedimiento: "+p1.getName()+ " del schema: "+ schemaA.getName() + " posee el mismo codigo que: "+p2.getName() + " del schema: "+ schemaB.getName());
					}else {
						System.out.println("		El procedimiento: "+p1.getName()+ " del schema: "+ schemaA.getName() + " no! posee el mismo codigo que: "+p2.getName() + " del schema: "+ schemaB.getName());
					}
					break;
				}
			}
		}

		// FUNCIONES
		System.out.println("\n");
		System.out.println(">> CHEQUEANDO FUNCIONES DEL SCHEMA " + schemaA.getName() + " EN EL SCHEMA " + schemaB.getName());
		for (Function f1:schemaA.getFunctions() ){
			System.out.println("	chequeando funcion: " + f1.getName());
			boolean exist = false;
			for (Function f2:schemaB.getFunctions() ){
				if(f1.getName().equals(f2.getName())){
					exist = true;
					break;
				}
			}
			if (!exist) 
				System.out.println(" El procedimiento "+ f1.getName() + " del schema " + schemaA.getName() + " no existe en el schema "+ schemaB.getName());
		}

		System.out.println("\n");
		System.out.println(">> CHEQUEANDO FUNCIONES DEL SCHEMA " + schemaB.getName() + " EN EL SCHEMA " + schemaA.getName());
		for (Function f1:schemaB.getFunctions() ){
			System.out.println("	chequeando funcion: " + f1.getName());
			boolean exist = false;
			for (Function f2:schemaA.getFunctions() ){
				if(f1.getName().equals(f2.getName())){
					exist = true;
					break;
				}
			}
			if (!exist) 
				System.out.println(f1.getName() + " no existe en "+ schemaA.getName());
		}

		System.out.println("\n");
		System.out.println(">> CHEQUEANDO FUNCIONES COMUNES EN AMBOS SCHEMAS");
		for (Function f1:schemaA.getFunctions() ){
			for (Function f2:schemaB.getFunctions() ){
				if(f1.equalsNameFunction(f2)){
					System.out.println("	La funcion: " + f1.getName() + " esta en ambos schemas");
					System.out.println("		CHEQUEANDO DIFERENCIA EN LOS PERFILES");
					
					// Chequeo el nombre 
					if (f1.equalsNameFunction(f2)){
						System.out.println("		La funcion: "+f1.getName()+ " del schema: "+ schemaA.getName() + " posee el mismo nombre que: "+f2.getName() + " del schema: "+ schemaB.getName());
					}else {
						System.out.println("		La funcion: "+f1.getName()+ " del schema: "+ schemaA.getName() + " no! posee el mismo nombre que: "+f2.getName() + " del schema: "+ schemaB.getName());
					}

					// Chequeo de los parametros (parameters)
					if (f1.equalsParam(f2)){
						System.out.println("		La funcion: "+f1.getName()+ " del schema: "+ schemaA.getName() + " posee los mismos parametros que: "+f2.getName() + " del schema: "+ schemaB.getName());
					}else {
						System.out.println("		La funcion: "+f1.getName()+ " del schema: "+ schemaA.getName() + " no! posee los mismos parametros que: "+f2.getName() + " del schema: "+ schemaB.getName());
					}
					
					// Chequeo de codigo 
					if (f1.equalsCode(f2)){
						System.out.println("		La funcion: "+f1.getName()+ " del schema: "+ schemaA.getName() + " posee el mismo codigo que: "+f2.getName() + " del schema: "+ schemaB.getName());
					}else {
						System.out.println("		La funcion: "+f1.getName()+ " del schema: "+ schemaA.getName() + " no! posee el mismo codigo que: "+f2.getName() + " del schema: "+ schemaB.getName());
					}
					
					// Chequeo de tipo de retorno
					if (f1.equalsReturntype(f2)){
						System.out.println("		La funcion: "+f1.getName()+ " del schema: "+ schemaA.getName() + " posee el mismo tipo de retorno que: "+f2.getName() + " del schema: "+ schemaB.getName());
					}else {
						System.out.println("		La funcion: "+f1.getName()+ " del schema: "+ schemaA.getName() + " no! posee el mismo tipo de retorno que: "+f2.getName() + " del schema: "+ schemaB.getName());
					}
					break;
				}
			}
		}
	}

}
