package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties = new Properties();

    public ConfigReader() {
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    static {
        try {
            FileInputStream fileInputStream = new FileInputStream("configuration.properties");
            properties.load(fileInputStream);
            fileInputStream.close();
        } catch (Exception var1) {
            var1.printStackTrace();
        }

    }
}