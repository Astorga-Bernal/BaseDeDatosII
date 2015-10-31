package src;

import src.utils.Settings;

public class Main {

	public static void main(String[] args) {
		String conf = "";
        if (args.length > 0) {
            conf = args[0];
        }    
        Settings.setConf(conf);
        System.out.println(Settings.getUrl_baseA());
        System.out.println(Settings.getUsernameA());
        System.out.println(Settings.getPasswordA());
        System.out.println(Settings.getUrl_baseB());
        System.out.println(Settings.getUsernameB());
        System.out.println(Settings.getPasswordB());
	}

}
