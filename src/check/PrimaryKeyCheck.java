package src.check;

import src.mysql.Column;
import src.mysql.Table;

public class PrimaryKeyCheck {

	private Table tableA;
	private Table tableB;

	public PrimaryKeyCheck(Table tableA, Table tableB) {
		super();
		this.tableA = tableA;
		this.tableB = tableB;
	}

	public void check() {

		if (tableA.getPrimarykey() != null && tableB.getPrimarykey() != null) {
			for (Column c1:tableA.getPrimarykey().getColums() ){
				boolean exist = false;
				for (Column c2:tableB.getPrimarykey().getColums() ){
					if(c1.equals(c2)){
						exist = true;
						break;
					}else if (c1.getName().equals(c2.getName())) {
						System.out.println(">>>>>>>>>> LAS PRIMARYKEY TIENEN LA MISMA COLUMNA: " + c1.getName() + " NO DEL MISMO TIPO");
						System.out.println("		 COLUMNA: "+c1.getName()+" - TIPO: "+ c1.getType().toString());
						System.out.println("	     COLUMNA: "+c2.getName()+" - TIPO: "+ c2.getType().toString());					
						exist = true;
						break;
					}
				}
				if (!exist) 
					System.out.println(">>>>>>>>>> LA COLUMNA "+ c1.getName() + " DE " + tableA.getPrimarykey().getName()  + " NO EXISTE EN "+ tableB.getPrimarykey().getName());
			}

			for (Column c1:tableB.getPrimarykey().getColums() ){
				boolean exist = false;
				for (Column c2:tableA.getPrimarykey().getColums() ){
					if(c1.equals(c2)){
						exist = true;
						break;
					}else if (c1.getName().equals(c2.getName())) {
						System.out.println(">>>>>>>>>> LAS PRIMARYKEY TIENEN LA MISMA COLUMNA: " + c1.getName() + " NO DEL MISMO TIPO");
						System.out.println("		 COLUMNA: "+c1.getName()+" - TIPO: "+ c1.getType().toString());
						System.out.println("	     COLUMNA: "+c2.getName()+" - TIPO: "+ c2.getType().toString());					
						exist = true;
						break;
					}
				}
				if (!exist) 
					System.out.println(">>>>>>>>>> LA COLUMNA "+ c1.getName() + " DE " + tableB.getPrimarykey().getName()  + " NO EXISTE EN "+ tableA.getPrimarykey().getName());
			}

			for (Column p1 : tableA.getPrimarykey().getColums()) {
				for (Column p2 : tableB.getPrimarykey().getColums()) {
					if (p1.getName().equals(p2.getName())) {
						System.out.println("			La PrimaryKey: " + tableA.getPrimarykey().getName() + " esta en ambos schemas");
						break;
					}
				}
			}

		} else if (tableA.getPrimarykey() == null && tableB.getPrimarykey() != null)
			System.out.println("La PrimaryKey " + tableB.getPrimarykey().getName() + " de la tabla " + tableB.getName()
					+ " no existe en la tabla " + tableA.getName());
		else if (tableB.getPrimarykey() == null && tableA.getPrimarykey() != null)
			System.out.println("La PrimaryKey " + tableA.getPrimarykey().getName() + " de la tabla " + tableA.getName()
					+ " no existe en la tabla " + tableB.getName());
		else
			System.out.println("Ambas tablas no tienen PrimaryKey");
	}

}
