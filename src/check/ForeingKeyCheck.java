package src.check;

import src.mysql.Table;
import src.mysql.ForeingKey;;

public class ForeingKeyCheck {

	private Table tableA;
	private Table tableB;

	public ForeingKeyCheck(Table tableA, Table tableB) {
		super();
		this.tableA = tableA;
		this.tableB = tableB;
	}

	public void check() {
		for (ForeingKey u1:tableA.getForeingkeys() ){
			boolean exist = false;
			for (ForeingKey u2:tableB.getForeingkeys() ){
				if(u1.equals(u2)){
					exist = true;
					break;
				}
			}
			if (!exist) 
				System.out.println("	La ForeingKey "+ u1.getName() + " de la tabla " + tableA.getName() + " no existe en la tabla "+ tableB.getName());
		}

		for (ForeingKey u1:tableB.getForeingkeys() ){
			boolean exist = false;
			for (ForeingKey u2:tableA.getForeingkeys() ){
				if(u1.getName().equals(u2.getName())){
					exist = true;
					break;
				}
			}
			if (!exist) 
				System.out.println(u1.getName() + " no existe en "+ tableA.getName());
		}

		for (ForeingKey f1:tableA.getForeingkeys() ){
			for (ForeingKey f2:tableB.getForeingkeys() ){
				if(f1.getName().equals(f2.getName())){
					System.out.println("			La ForeingKey: " + f1.getName() + " esta en ambos schemas");

					// Chequeo el name 
					if (f1.equalName(f2)){
						System.out.println("			La ForeingKey: "+f1.getName()+ " de la tabla "+ tableA.getName() + " posee el mismo nombre que "+f2.getName() + " de la tabla "+ tableB.getName());
					}else {
						System.out.println("			La ForeingKey: "+f1.getName()+ " de la tabla "+ tableA.getName() + " no! posee el mismo nombre que "+f2.getName() + " de la tabla "+ tableB.getName());
					}

					// Chequeo el Columns 
					if (f1.equalColums(f2)){
						System.out.println("			La ForeingKey: "+f1.getName()+ " de la tabla "+ tableA.getName() + " posee las mismas colums que "+f2.getName() + " de la tabla "+ tableB.getName());
					}else {
						System.out.println("			La ForeingKey: "+f1.getName()+ " de la tabla "+ tableA.getName() + " no! posee las mismas colums que "+f2.getName() + " de la tabla "+ tableB.getName());
					}
					
					
					// Chequeo el Table 
					if (f1.equalTable(f2)){
						System.out.println("			La ForeingKey: "+f1.getName()+ " de la tabla "+ tableA.getName() + " posee la misma Table que "+f2.getName() + " de la tabla "+ tableB.getName());
					}else {
						System.out.println("			La ForeingKey: "+f1.getName()+ " de la tabla "+ tableA.getName() + " no! posee la misma Table que "+f2.getName() + " de la tabla "+ tableB.getName());
					}
					
					// Chequeo el Restriction (event, action)
					if (f1.equalRestriction(f2)){
						System.out.println("			La ForeingKey: "+f1.getName()+ " de la tabla "+ tableA.getName() + " posee la misma Restriction que "+f2.getName() + " de la tabla "+ tableB.getName());
					}else {
						System.out.println("			La ForeingKey: "+f1.getName()+ " de la tabla "+ tableA.getName() + " no! posee la misma Restriction que "+f2.getName() + " de la tabla "+ tableB.getName());
					}
					break;
				}
			}
		}
	}
	
}

