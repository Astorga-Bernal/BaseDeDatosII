package src.check;

import src.mysql.Schema;
import src.mysql.Table;

public class TableCheck {

	private Schema schemaA;
	private Schema schemaB;

	public TableCheck(Schema schemaA, Schema schemaB) {
		super();
		this.schemaA = schemaA;
		this.schemaB = schemaB;
	}

	public void check() {
		//Chequeo de tablas del esquema A y no en B
		for (Table t1:schemaA.getTables() ){
			boolean exist = false;
			for (Table t2:schemaB.getTables() ){
				if(t1.equals(t2)){
					exist = true;
					break;
				}
			}
			if (!exist) 
				System.out.println("La tabla "+ t1.getName() + " del schema " + schemaA.getName() + " no existe en el schema "+ schemaB.getName());
		}

		//Chequeo de tablas del esquema B
		for (Table t1:schemaB.getTables() ){
			boolean exist = false;
			for (Table t2:schemaA.getTables() ){
				if(t1.getName().equals(t2.getName())){
					exist = true;
					break;
				}
			}
			if (!exist) 
				System.out.println(t1.getName() + "No existe en "+ schemaB.getName());
		}

		//Chequeo de tablas en ambos esquemas
		for (Table t1:schemaA.getTables() ){
			for (Table t2:schemaB.getTables() ){
				if(t1.getName().equals(t2.getName())){
					System.out.println(t1.getName()+"Esta en ambos schemas");
					break;
				}
			}

		}
	}

}
