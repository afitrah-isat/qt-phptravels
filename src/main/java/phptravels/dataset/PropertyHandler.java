package phptravels.dataset;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class PropertyHandler {

	private String propertyFile = "";
	private static final Logger logger = LogManager.getLogger(PropertyHandler.class);

	public PropertyHandler(String filePath) {
		propertyFile = filePath;
	}

	private Properties readFromFile() {
		Properties properties = new Properties();
		try (InputStreamReader fileReader = new InputStreamReader(new FileInputStream(propertyFile))) {
			properties.load(fileReader);
			fileReader.close();
		} catch (IOException e) {
            logger.error("Property file not found!");
			e.printStackTrace();
		}

		return properties;
	}

	public String getValue(String propertyName) {
		String propertyValue;
		propertyValue = (readFromFile().getProperty(propertyName));
		return propertyValue;
	}

	public void updateValue(String propertyName, String newValue) {
		Properties dataProperties = readFromFile();

		try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(propertyFile))) {
			dataProperties.setProperty(propertyName, newValue);
			dataProperties.store(writer, null);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
