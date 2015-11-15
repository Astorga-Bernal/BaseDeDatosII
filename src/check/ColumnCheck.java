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
				}
			}
			if (!exist) 
				System.out.println("La columna "+ c1.getName() + " de la tabla " + tableA.getName()  + " no existe en la tabla "+ tableB.getName());
		}

		//Chequeo de columnas de la tabla B
		for (Column c1:tableB.getColums() ){
			boolean exist = false;
			for (Column c2:tableA.getColums() ){
				if(c1.getName().equals(c2.getName())){
					exist = true;
					break;
				}
			}
			if (!exist) 
				System.out.println("La columna "+ c1.getName() + " no existe en "+ tableB.getName());
		}

		//Chequeo de columnas en ambas tablas
		for (Column c1:tableA.getColums() ){
			for (Column c2:tableB.getColums() ){
				if(c1.getName().equals(c2.getName())){
					System.out.println("La columna "+ c1.getName() +" esta en ambos schemas");
					break;
				}
			}

		}
	}

}
