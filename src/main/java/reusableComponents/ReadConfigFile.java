package reusableComponents;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;

public class ReadConfigFile {

	static Properties prop=new Properties();
	public static String getPropertyValueByKey(String key) throws IOException {
	
		String filePath=System.getProperty("user.dir")+"/src/test/resources/configfile.properties";
		FileInputStream fis=new FileInputStream(filePath);
		prop.load(fis);
		
		String value = prop.getProperty(key).toString();
		
		if(StringUtils.isEmpty(value)) {
			
			throw new RuntimeException("There's not present value in properties file..");
			
		}
		
		return value;
		
	}
	
}
