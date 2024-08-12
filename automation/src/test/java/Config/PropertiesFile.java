package Config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFile {

	static Properties prop = new Properties();
	static String Projectpath = System.getProperty("user.dir");

	public static void main(String[] args) {
		getProperties();
		setProperties();
	}

	public static void getProperties() {
		try {

			FileInputStream input = new FileInputStream(Projectpath + "/src/test/java/Config/config.poperties");
			prop.load(input);
			String browser = prop.getProperty("browser");
			System.out.println(browser);
		} catch (Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}

	}

public static void setProperties() {
	try {
	FileOutputStream output = new FileOutputStream(Projectpath+"/src/test/java/Config/config.poperties");
prop.setProperty("browser", "chrome");
prop.store(output, "null");
	}catch(Exception exp) {
		System.out.println(exp.getMessage());
		System.out.println(exp.getCause());
		exp.printStackTrace();
	}
}
}
