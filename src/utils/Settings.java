package src.utils;

public class Settings {

	private static String url_baseA;
	private static String usernameA;
	private static String passwordA;
	private static String schemaA;
	private static String url_baseB;
	private static String usernameB;
	private static String passwordB;
	private static String schemaB;

	public static String getSchemaA() {
		return schemaA;
	}

	public static void setSchemaA(String schemaA) {
		Settings.schemaA = schemaA;
	}

	public static String getSchemaB() {
		return schemaB;
	}

	public static void setSchemaB(String schemaB) {
		Settings.schemaB = schemaB;
	}

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
		schemaA = ini.getParameters("schemaA");
		url_baseA = ini.getParameters("url_baseA")+schemaA;
		usernameA = ini.getParameters("usernameA");
		passwordA = ini.getParameters("passwordA");
		
		schemaB = ini.getParameters("schemaB");
		url_baseB = ini.getParameters("url_baseB")+schemaB;
		usernameB = ini.getParameters("usernameB");
		passwordB = ini.getParameters("passwordB");
	}
}
