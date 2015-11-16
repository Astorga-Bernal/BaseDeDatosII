package src.check;

import src.mysql.Table;
import src.mysql.Column;;

public class ColumnCheck {

	private Table tableA;
	private Table tableB;

	public ColumnCheck(Table tableA, Table tableB) {
		super();
		this.tableA = tableA;
		this.tableB = tableB;
	}

	public void check() {
		//Chequeo de columnas de la tabla A y no en B
		for (Column c1:tableA.getColums() ){
			boolean exist = false;
			for (Column c2:tableB.getColums() ){
				if(c1.equals(c2)){
					exist = true;
					break;
				}else if (c1.getName().equals(c2.getName())) {
					System.out.println(">>>>>>>>>> LAS TABLAS TIENEN LA MISMA COLUMNA: " + c1.getName() + " NO DEL MISMO TIPO");
					System.out.println("		 COLUMNA: "+c1.getName()+" - TIPO: "+ c1.getType().toString());
					System.out.println("	     COLUMNA: "+c2.getName()+" - TIPO: "+ c2.getType().toString());					
					exist = true;
					break;
				}
			}
			if (!exist) 
				System.out.println(">>>>>>>>>> LA COLUMNA "+ c1.getName() + " DE " + tableA.getName()  + " NO EXISTE EN "+ tableB.getName());
		}

		//Chequeo de columnas de la tabla B
		for (Column c1:tableB.getColums() ){
			boolean exist = false;
			for (Column c2:tableA.getColums() ){
				if(c1.getName().equals(c2.getName())){
					exist = true;
					break;
				}else if (c1.getName().equals(c2.getName())) {
					exist = true;
					break;
				}
			}
			if (!exist) 
				System.out.println(">>>>>>>>>> LA COLUMNA "+ c1.getName() + " DE " + tableB.getName()  + " NO EXISTE EN "+ tableA.getName());
		}

		//Chequeo de columnas en ambas tablas
		for (Column c1:tableA.getColums() ){
			for (Column c2:tableB.getColums() ){
				if(c1.getName().equals(c2.getName())){
					System.out.println("			"+ c1.getName() +" - TIPO: "+ c1.getType().toString() + " 	existe en ambas");
					break;
				}
			}

		}
	}

}
