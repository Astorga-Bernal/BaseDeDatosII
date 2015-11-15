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
		// Chequeo de tablas del esquema A y no en B
		System.out
				.println(">> CHEQUEANDO TABLAS DEL SCHEMA " + schemaA.getName() + " EN EL SCHEMA " + schemaB.getName());
		for (Table t1 : schemaA.getTables()) {
			System.out
			.println(">>>> CHEQUEANDO TABLA: " + t1.getName());
			boolean exist = false;
			for (Table t2 : schemaB.getTables()) {
				if (t1.equals(t2)) {
					exist = true;
					break;
				} else {
					if (t1.getName().equals(t2.getName())) {
						System.out.println(
								">>>>>> LA TABLA " + t2.getName() + " ES DIFERENTE EN LOS SCHEMAS");
						System.out.println(">>>>>>>> CHEQUEANDO COLUMNAS");
						ColumnCheck columnCheck = new ColumnCheck(t1, t2);
						columnCheck.check();
						exist = true;
						break;
					}
				}
			}
			if (!exist)
				System.out.println(">>>>>> LA TABLA " + t1.getName() + " EN " + schemaA.getName()
						+ " NO EXISTE EN " + schemaB.getName());
		}
		System.out.println(">> CHEQUEANDO TABLAS DEL SCHEMA " + schemaB.getName() + " EN EL SCHEMA "
				+ schemaA.getName());
		// Chequeo de tablas del esquema B
		for (Table t1 : schemaB.getTables()) {
			System.out
			.println(">>>> CHEQUEANDO TABLA: " + t1.getName());
			boolean exist = false;
			for (Table t2 : schemaA.getTables()) {
				if (t1.getName().equals(t2.getName())) {
					exist = true;
					break;
				} else if (t1.getName().equals(t2.getName())) {
					exist = true;
					break;
				}
			}
			if (!exist)
				System.out.println(t1.getName() + "No existe en " + schemaB.getName());
		}
		System.out.println(">> CHEQUEANDO TABLAS COMUNES EN AMBOS SCHEMAS");
		// Chequeo de tablas en ambos esquemas
		for (Table t1 : schemaA.getTables()) {
			for (Table t2 : schemaB.getTables()) {
				if (t1.getName().equals(t2.getName())) {
					System.out.println(">>>> LA TABLA " + t1.getName() + " ESTA EN AMBOS SCHEMAS");
					System.out.println(">>>>>> CHEQUEANDO COLUMNAS");
					ColumnCheck columnCheck = new ColumnCheck(t1, t2);
					columnCheck.check();
					break;
				}
			}

		}
	}

}
