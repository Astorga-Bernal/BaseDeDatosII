package src.check;

import src.mysql.Table;
import src.mysql.Index;;

public class IndexCheck {
	
	private Table tableA;
	private Table tableB;

	public IndexCheck(Table tableA, Table tableB) {
		super();
		this.tableA = tableA;
		this.tableB = tableB;
	}

	public void check() {
		for (Index u1:tableA.getIndexs() ){
			boolean exist = false;
			for (Index u2:tableB.getIndexs() ){
				if(u1.equals(u2)){
					exist = true;
					break;
				}
			}
			if (!exist) 
				System.out.println("El Index "+ u1.getName() + " de la tabla " + tableA.getName() + " no existe en la tabla "+ tableB.getName());
		}

		for (Index u1:tableB.getIndexs() ){
			boolean exist = false;
			for (Index u2:tableA.getIndexs() ){
				if(u1.getName().equals(u2.getName())){
					exist = true;
					break;
				}
			}
			if (!exist) 
				System.out.println(u1.getName() + " no existe en "+ tableA.getName());
		}

		for (Index i1:tableA.getIndexs() ){
			for (Index i2:tableB.getIndexs() ){
				if(i1.getName().equals(i2.getName())){
					System.out.println("			El Index: " + i1.getName() + " esta en ambos schemas");

					// Chequeo el name 
					if (i1.equalName(i2)){
						System.out.println("			El Index: "+i1.getName()+ " de la tabla "+ tableA.getName() + " posee el mismo nombre que "+i2.getName() + " de la tabla "+ tableB.getName());
					}else {
						System.out.println("			El Index: "+i1.getName()+ " de la tabla "+ tableA.getName() + " no! posee el mismo nombre que "+i2.getName() + " de la tabla "+ tableB.getName());
					}

					// Chequeo el Columns 
					if (i1.equalColums(i2)){
						System.out.println("			El Index: "+i1.getName()+ " de la tabla "+ tableA.getName() + " posee las mismas colums que "+i2.getName() + " de la tabla "+ tableB.getName());
					}else {
						System.out.println("			El Index: "+i1.getName()+ " de la tabla "+ tableA.getName() + " no! posee las mismas colums que "+i2.getName() + " de la tabla "+ tableB.getName());
					}
					break;
				}
			}
		}

	}

}
