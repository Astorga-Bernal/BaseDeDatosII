package src;

import src.check.TableCheck;
import src.metadata.Metadata;
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

		Metadata mda = new Metadata(Settings.getSchemaA(),databaseA);
		Metadata mdb = new Metadata(Settings.getSchemaB(),databaseB);
				
		TableCheck tableCheck = new TableCheck(mda.getSchema(), mdb.getSchema());
		tableCheck.check();
	}
}
