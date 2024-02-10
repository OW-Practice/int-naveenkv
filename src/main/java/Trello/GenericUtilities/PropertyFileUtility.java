package Trello.GenericUtilities;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFileUtility 
{
	/**
	 * This method will read the data from property file with the help key and return the value
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	public String readDataFromPropertyFile(String key) throws Throwable
	{
		FileInputStream fis=new FileInputStream(IConstantUtility.propertyFilePath);
		Properties p=new Properties();
		p.load(fis);
		System.out.println("");
		return p.getProperty(key);		
	}
}
