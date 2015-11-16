package src.check;

import src.mysql.Table;
import src.mysql.PrimaryKey;

public class PrimaryKeyCheck {

	private Table tableA;
	private Table tableB;

	public PrimaryKeyCheck(Table tableA, Table tableB) {
		super();
		this.tableA = tableA;
		this.tableB = tableB;
	}

//	public void check() {
//		for (PrimaryKey u1:tableA.getPrimarykey() ){
//			boolean exist = false;
//			for (PrimaryKey u2:tableB.getPrimarykey() ){
//				if(u1.equals(u2)){
//					exist = true;
//					break;
//				}
//			}
//			if (!exist) 
//				System.out.println("La PrimaryKey "+ u1.getName() + " de la tabla " + tableA.getName() + " no existe en la tabla "+ tableB.getName());
//		}
//
//		for (PrimaryKey u1:tableB.getPrimarykey() ){
//			boolean exist = false;
//			for (PrimaryKey u2:tableA.getPrimarykey() ){
//				if(u1.getName().equals(u2.getName())){
//					exist = true;
//					break;
//				}
//			}
//			if (!exist) 
//				System.out.println(u1.getName() + " no existe en "+ tableA.getName());
//		}
//
//		for (PrimaryKey p1:tableA.getPrimarykey() ){
//			for (PrimaryKey p2:tableB.getPrimarykey() ){
//				if(p1.getName().equals(p2.getName())){
//					System.out.println("			La PrimaryKey: " + p1.getName() + " esta en ambos schemas");
//
//					// Chequeo el name 
//					if (p1.equalName(p2)){
//						System.out.println("			La PrimaryKey: "+p1.getName()+ " de la tabla "+ tableA.getName() + " posee el mismo nombre que "+p2.getName() + " de la tabla "+ tableB.getName());
//					}else {
//						System.out.println("			La PrimaryKey: "+p1.getName()+ " de la tabla "+ tableA.getName() + " no! posee el mismo nombre que "+p2.getName() + " de la tabla "+ tableB.getName());
//					}
//					
//					// Chequeo el Columns 
//					if (p1.equalColumns(p2)){
//						System.out.println("			La PrimaryKey: "+p1.getName()+ " de la tabla "+ tableA.getName() + " posee las mismas colums que "+p2.getName() + " de la tabla "+ tableB.getName());
//					}else {
//						System.out.println("			La PrimaryKey: "+p1.getName()+ " de la tabla "+ tableA.getName() + " no! posee las mismas colums que "+p2.getName() + " de la tabla "+ tableB.getName());
//					}
//					break;
//				}
//			}
//		}
//		
//	}

}
