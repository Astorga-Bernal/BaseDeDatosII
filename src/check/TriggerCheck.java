package src.check;

import src.mysql.Table;
import src.mysql.Trigger;

public class TriggerCheck {
	
	private Table tableA;
	private Table tableB;
	
	public TriggerCheck(Table tableA, Table tableB) {
		super();
		this.tableA = tableA;
		this.tableB = tableB;
	}
	
	public void check() {
		for (Trigger t1:tableA.getTrigges() ){
			boolean exist = false;
			for (Trigger t2:tableB.getTrigges() ){
				if(t1.equals(t2)){
					exist = true;
					break;
				}
			}
			if (!exist) 
				System.out.println("			El trigger: "+ t1.getName() + " de la tabla " + tableA.getName()  + " no! existe en la tabla "+ tableB.getName());
		}

		for (Trigger t1:tableB.getTrigges() ){
			boolean exist = false;
			for (Trigger t2:tableA.getTrigges() ){
				if(t1.getName().equals(t2.getName())){
					exist = true;
					break;
				}
			}
			if (!exist) 
				System.out.println("			El trigger: "+ t1.getName() + " de la tabla " + tableB.getName()  + " no! existe en la tabla "+ tableA.getName());
		}

		for (Trigger t1:tableA.getTrigges() ){
			for (Trigger t2:tableB.getTrigges() ){
				if(t1.getName().equals(t2.getName())){
					System.out.println("			El trigger: "+ t1.getName() +" esta en ambas tablas");
					break;
				}
			}

		}
	}
}
