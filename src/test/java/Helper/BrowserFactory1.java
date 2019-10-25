/**
 * 
 */
package Helper;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * @author Yogesh
 *
 */
public class BrowserFactory1 {
	
	static WebDriver driver;
	String url;
    static JSONParser parser=new JSONParser();
	
	public static WebDriver startBrowser(String browserName,String url) throws FileNotFoundException, IOException, ParseException{
		if(browserName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "Drivers/geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
			driver=new ChromeDriver();
		}		
		else if (browserName.equals("EdgeDriver"))
		{
			System.setProperty("webdriver.edge.driver", "Drivers/MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
		}
		//else if (browserName.equals("IE"))
		//{
			//System.setProperty("webdriver.IE.driver", "IEDriverServer.exe");
			//driver=new InternetExplorerDriver();
		//}
		
		driver.manage().window().maximize();
		
		Object obj = parser.parse(new FileReader("src/test/java/JSONData/urlforadmin.json"));
		JSONObject jsonObject = (JSONObject) obj;
		 url = (String) jsonObject.get("URL");
		 
		driver.get(url);
		return driver;
	}
	

}