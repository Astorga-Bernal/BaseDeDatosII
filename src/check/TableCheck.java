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
		System.out.println("\n");
		System.out.println("----------------- NIVEL TABLAS -----------------");System.out.println("\n");
		// Chequeo de tablas del esquema A y no en B
		System.out
				.println(">> CHEQUEANDO TABLAS DEL SCHEMA " + schemaA.getName() + " EN EL SCHEMA " + schemaB.getName());
		for (Table t1 : schemaA.getTables()) {
			System.out.println(">>>> Chequeando tabla: " + schemaA.getName() + "." + t1.getName());
			boolean exist = false;
			for (Table t2 : schemaB.getTables()) {
				if (t1.equals(t2)) {
					exist = true;
					break;
				} else {
					if (t1.getName().equals(t2.getName())) {
						System.out.println(">>>> LA TABLA " + schemaB.getName() + "." + t2.getName()
								+ " TIENEN EL MISMO NOMBRE ");
						
						System.out.println(">>>>>> CHEQUEO DE COLUMNAS DE LA TABLA " + t1.getName());
						ColumnCheck columnCheck = new ColumnCheck(t1, t2);
						columnCheck.check();
						
						System.out.println(">>>>>> CHEQUEO DE TRIGGER DE LA TABLA " + t1.getName());
						TriggerCheck triggerCheck = new TriggerCheck(t1, t2);
						triggerCheck.check();

						System.out.println(">>>>>> CHEQUEO DE UNIQUEKEY DE LA TABLA " + t1.getName());
						UniqueKeyCheck uniqueKeyCheck = new UniqueKeyCheck(t1, t2);
						uniqueKeyCheck.check();

						System.out.println(">>>>>> CHEQUEO DE PRIMARYKEY " + t1.getName());
						;
						PrimaryKeyCheck primaryKeyCheck = new PrimaryKeyCheck(t1, t2);
						primaryKeyCheck.check();

						System.out.println(">>>>>> CHEQUEO DE FOREINGKEY DE LA TABLA " + t1.getName());
						ForeingKeyCheck foreingKeyCheck = new ForeingKeyCheck(t1, t2);
						foreingKeyCheck.check();

						System.out.println(">>>>>> CHEQUEO DE INDEX DE LA TABLA " + t1.getName());
						IndexCheck indexCheck = new IndexCheck(t1, t2);
						indexCheck.check();
						
						exist = true;
						break;
					}
				}
			}
			if (!exist)
				System.out.println(">>>> La tabla " + t1.getName() + " en " + schemaA.getName() + " no! existe en "
						+ schemaB.getName());
			else
				System.out.println(">>>> La tabla " + t1.getName() + " en " + schemaA.getName() + " existe en "
						+ schemaB.getName());

		}

		System.out.println("\n");
		System.out
				.println(">> CHEQUEANDO TABLAS DEL SCHEMA " + schemaB.getName() + " EN EL SCHEMA " + schemaA.getName());
		// Chequeo de tablas del esquema B
		for (Table t1 : schemaB.getTables()) {
			System.out.println(">>>> Chequeando tabla: " + schemaB.getName() + "." + t1.getName());
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
				System.out.println(">>>> La tabla " + t1.getName() + " en " + schemaB.getName() + " no! existe en "
						+ schemaA.getName());
			else
				System.out.println(">>>> La tabla " + t1.getName() + " en " + schemaB.getName() + " existe en "
						+ schemaA.getName());
		}

		System.out.println("\n");
		System.out.println(">> CHEQUEANDO TABLAS COMUNES EN AMBOS SCHEMAS");
		// Chequeo de tablas en ambos esquemas
		for (Table t1 : schemaA.getTables()) {
			for (Table t2 : schemaB.getTables()) {
				if (t1.equals(t2)) {
					System.out.println(">>>> LA TABLA: " + t1.getName() + " TIENE LAS MISMAS COLUMNAS EN AMBOS SCHEMAS");
					System.out.println(">>>> LA TABLA: " + t1.getName() + " TIENE LOS MISMOS TRIGGERS EN AMBOS SCHEMAS");
					System.out.println(">>>> LA TABLA: " + t1.getName() + " TIENE LAS MISMAS UNIQUEKEY EN AMBOS SCHEMAS");
					System.out.println(">>>> LA TABLA: " + t1.getName() + " TIENE LAS MISMAS PRIMARYKEYS EN AMBOS SCHEMAS");
					System.out.println(">>>> LA TABLA: " + t1.getName() + " TIENE LAS MISMAS FOREINGKEYS EN AMBOS SCHEMAS");
					System.out.println(">>>> LA TABLA: " + t1.getName() + " TIENE LOS MISMOS INDEXS EN AMBOS SCHEMAS");
					System.out.println("\n");
					break;
				}
			}
		}
	}

}
