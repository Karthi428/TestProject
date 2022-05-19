package configreader;
import java.io.FileReader;
import java.util.Properties;

public class PropertiesReader 
{
	Properties pr = new Properties();
	public PropertiesReader()
	{
		FileReader fr;
		try {
			fr = new FileReader("C:\\Users\\2078130\\eclipse-workspace\\SearchforSchoolMiniProject\\ObjectSource\\propertyobject.properties");
			//loads file into property object
			pr.load(fr);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	public String getBrowser()
	{
		//gets value of the "browser" key from propertyobject file
		return pr.getProperty("browser");
	}
	public String getchormekey()
	{
		//gets value of the "chromekey" key from propertyobject file
		return pr.getProperty("chromekey");
	}
	public String getchromepath() 
	{
		//gets value of the "chromepath" key from propertyobject file
		return pr.getProperty("chromepath");
	}
	public String geturl()
	{
		//gets value of the "url" key from propertyobject file
		return pr.getProperty("url");
	}
	public String getfirefoxkey()
	{
		//gets value of the "firefoxkey" key from propertyobject file
		return pr.getProperty("firefoxkey");
	}
	public String getfirefoxpath()
	{
		//gets value of the "firefoxpath" key from propertyobject file
		return pr.getProperty("firefoxpath");
	}
}
