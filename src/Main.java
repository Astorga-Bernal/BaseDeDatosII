package src;

import java.sql.ResultSet;
import com.mysql.jdbc.Statement;

import src.utils.Settings;

public class Main {

	public static void main(String[] args) {
  
		String conf = "";
        if (args.length > 0) {
            conf = args[0];
        }    
        Settings.setConf(conf);
        Settings.getUrl_baseA();
        Settings.getUsernameA();
        Settings.getPasswordA();
        Settings.getUrl_baseB();
        Settings.getUsernameB();
        Settings.getPasswordB();

	}
}
