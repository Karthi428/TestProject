package objectutility;

import java.io.FileReader;
import java.util.Properties;


public class PropertyReaders 
{
	
	Properties pr = new Properties();
	public PropertyReaders()
	{
		FileReader fr;
		try {
			fr = new FileReader("./ObjectRepository/PropertyObj.properties");
			//loads file into property object
			pr.load(fr);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	public String getchormekey()
	{
		//gets value of the "chromekey" key from PropertyObj file
		return pr.getProperty("chromekey");
	}
	public String getchromepath() 
	{
		//gets value of the "chromepath" key from PropertyObj file
		return pr.getProperty("chromepath");
	}
	public String geturl()
	{
		//gets value of the "url" key from PropertyObj file
		return pr.getProperty("url");
	}
	public String getfirefoxkey()
	{
		//gets value of the "firefoxkey" key from PropertyObj file
		return pr.getProperty("firefoxkey");
	}
	public String getedgepath()
	{
		//gets value of the "firefoxpath" key from PropertyObj file
		return pr.getProperty("edgepath");
	}
	public String getedgekey()
	{
		//gets value of the "edgekey" key from PropertyObj file
		return pr.getProperty("edgekey");
	}
	public String getfirefoxpath()
	{
		//gets value of the "edgepath" key from PropertyObj file
		return pr.getProperty("firefoxpath");
	}
	public String getcoursename()
	{
		//gets value of the "coursename" key from PropertyObj file
		return pr.getProperty("coursename");
	}
}

