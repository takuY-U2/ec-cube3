package eccube3.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class EcCube3Configuration {

    private static final String CONFIGURATION_FILE_PATH = "/ec-cube3.conf";
    private static final EcCube3Configuration INSTANCE = new EcCube3Configuration();
    private Properties properties;

    public static EcCube3Configuration getInstance() {
        return INSTANCE;
    }

    private EcCube3Configuration() {
        String configurationFilePath = CONFIGURATION_FILE_PATH;
        InputStream is = this.getClass().getResourceAsStream(configurationFilePath);
        if (is != null) {
            properties = new Properties();
            try {
                properties.load(is);
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(String.format("Cannot read configuration file : %s", configurationFilePath), e);
            }
        } else {
            throw new RuntimeException(String.format("Cannot read configuration file : %s", configurationFilePath));
        }
    }

    public String get(String key) {
        if (System.getProperties().containsKey(key)) {
            return System.getProperty(key);
        } else {
            return (String) properties.get(key);
        }
    }
}
