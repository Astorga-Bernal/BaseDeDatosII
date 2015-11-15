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
		System.out.println("----------------- NIVEL PROCEDIMIENTOS/FUNCIONES -----------------");
		
		// MISMOS PROCEDIMIENTOS
		for (StoredProcedure p1:schemaA.getStoreprocedures() ){
			boolean exist = false;
			for (StoredProcedure p2:schemaB.getStoreprocedures() ){
				if(p1.equals(p2)){
					exist = true;
					break;
				}
			}
			if (!exist) 
				System.out.println("El procedimiento "+ p1.getName() + " del schema " + schemaA.getName() + " no existe en el schema "+ schemaB.getName());
		}

		for (StoredProcedure p1:schemaB.getStoreprocedures() ){
			boolean exist = false;
			for (StoredProcedure p2:schemaA.getStoreprocedures() ){
				if(p1.getName().equals(p2.getName())){
					exist = true;
					break;
				}
			}
			if (!exist) 
				System.out.println(p1.getName() + " no existe en "+ schemaA.getName());
		}
		
		for (StoredProcedure p1:schemaA.getStoreprocedures() ){
			for (StoredProcedure p2:schemaB.getStoreprocedures() ){
				if(p1.getName().equals(p2.getName())){
					System.out.println(p1.getName()+" esta en ambos schemas");
					break;
				}
			}
		}
		
		// MISMAS FUNCIONES
		for (Function f1:schemaA.getFunctions() ){
			boolean exist = false;
			for (Function f2:schemaB.getFunctions() ){
				if(f1.equals(f2)){
					exist = true;
					break;
				}
			}
			if (!exist) 
				System.out.println("El procedimiento "+ f1.getName() + " del schema " + schemaA.getName() + " no existe en el schema "+ schemaB.getName());
		}

		for (Function f1:schemaB.getFunctions() ){
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
		
		for (Function f1:schemaA.getFunctions() ){
			for (Function f2:schemaB.getFunctions() ){
				if(f1.getName().equals(f2.getName())){
					System.out.println(f1.getName()+" esta en ambos schemas");
					
					
					
					break;
				}
			}
		}
		
		
		
		
		
		
		
		
		// Indicar si tienen los mismo Procedimientos/Funciones  listo
		
		// Indicar Procedimientos/Funciones adicionales  listo
		
		// Procedimientos 
			// Indicar diferencias entre perfiles
	
	}

}
