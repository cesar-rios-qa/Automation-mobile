package utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class TestDataReader {

    private static final Properties configFile;

    private TestDataReader() {
        throw new IllegalStateException("Utility class");
    }
    static {
        try {
            String path;
            path = System.getProperty("user.dir") + "/src/test/resources/testdata/dataQA.properties";
            FileReader input = new FileReader(path);
            configFile = new Properties();
            configFile.load(input);
            input.close();
        } catch (IOException e) {
            throw new AutomationException(e.getMessage());
        }
    }

    /**
     * Get the properties the test data file
     * @param keyName the key name
     * @return Value the properties test data file
     */
    public static String getProperty(String keyName) {
        return configFile.getProperty(keyName);
    }
}
