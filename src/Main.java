package src;

import src.metadata.Metadata;
import src.mysql.Table;
import src.utils.Settings;

public class Main {

	public static void main(String[] args) {

		String conf = "";
		if (args.length > 0) {
			conf = args[0];
		}
		Settings.setConf(conf);
		DatabaseConnection databaseA = new DatabaseConnection(Settings.getUrl_baseA(), Settings.getUsernameA(),
				Settings.getPasswordA());
		DatabaseConnection databaseB = new DatabaseConnection(Settings.getUrl_baseB(), Settings.getUsernameB(),
				Settings.getPasswordB());

		Metadata a = new Metadata("basea",databaseA);
		for(Table s: a.getTables()){
			System.out.println(s.getName() + "\n");
		}
		
		
	}
}
