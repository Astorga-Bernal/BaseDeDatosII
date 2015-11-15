package src.check;

import src.mysql.Table;
import src.mysql.UniqueKey;

public class UniqueKeyCheck {

	private Table tableA;
	private Table tableB;

	public UniqueKeyCheck(Table tableA, Table tableB) {
		super();
		this.tableA = tableA;
		this.tableB = tableB;
	}

	public void check() {
		for (UniqueKey u1:tableA.getUniquekeys() ){
			boolean exist = false;
			for (UniqueKey u2:tableB.getUniquekeys() ){
				if(u1.equals(u2)){
					exist = true;
					break;
				}
			}
			if (!exist) 
				System.out.println("La UniqueKey "+ u1.getName() + " de la tabla " + tableA.getName() + " no existe en la tabla "+ tableB.getName());
		}

		for (UniqueKey u1:tableA.getUniquekeys() ){
			boolean exist = false;
			for (UniqueKey u2:tableB.getUniquekeys() ){
				if(u1.getName().equals(u2.getName())){
					exist = true;
					break;
				}
			}
			if (!exist) 
				System.out.println(u1.getName() + " no existe en "+ tableB.getName());
		}

		for (UniqueKey u1:tableA.getUniquekeys() ){
			for (UniqueKey u2:tableB.getUniquekeys() ){
				if(u1.getName().equals(u2.getName())){
					System.out.println(u1.getName()+" esta en ambas tablas");
					break;
				}
			}

		}
	}

}
