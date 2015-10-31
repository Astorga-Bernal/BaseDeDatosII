package src.utils;

public class Settings {

	private static String url_baseA = "jdbc:mysql://localhost/basea";
	private static String usernameA = "root";
	private static String passwordA = "roor";
	private static String url_baseB = "jdbc:mysql://localhost/baseb";
	private static String usernameB = "root";
	private static String passwordB = "root";

	public static String getUrl_baseA() {
		return url_baseA;
	}

	public static void setUrl_baseA(String url_baseA) {
		Settings.url_baseA = url_baseA;
	}

	public static String getUsernameA() {
		return usernameA;
	}

	public static void setUsernameA(String usernameA) {
		Settings.usernameA = usernameA;
	}

	public static String getPasswordA() {
		return passwordA;
	}

	public static void setPasswordA(String passwordA) {
		Settings.passwordA = passwordA;
	}

	public static String getUrl_baseB() {
		return url_baseB;
	}

	public static void setUrl_baseB(String url_baseB) {
		Settings.url_baseB = url_baseB;
	}

	public static String getUsernameB() {
		return usernameB;
	}

	public static void setUsernameB(String usernameB) {
		Settings.usernameB = usernameB;
	}

	public static String getPasswordB() {
		return passwordB;
	}

	public static void setPasswordB(String passwordB) {
		Settings.passwordB = passwordB;
	}

	public static void setConf(String nameFile) {
		if ((nameFile == null) || (nameFile.trim().length() == 0)) {
			nameFile = "conf.ini";
		}
		ConfInit ini = new ConfInit(nameFile);
		url_baseA = ini.getParameters("url_baseA");
		usernameA = ini.getParameters("usernameA");
		passwordA = ini.getParameters("passwordA");
		url_baseB = ini.getParameters("url_baseB");
		usernameB = ini.getParameters("usernameB");
		passwordB = ini.getParameters("passwordB");
	}
}
