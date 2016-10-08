package jquery.corewarpper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Wrapper 

{

	private RemoteWebDriver driver;
	
	private DesiredCapabilities capabilities;
	
	 protected Properties prop;
	
	
public Properties propertyfile()
{
	
	String s1= "C:\\Users\\Basith\\workspace\\Jquery\\src\\bjectRepository\\property.properties";

	prop = new Properties();
	
	File file = new File(s1);
	
	FileInputStream format = null;
	try {
		format = new FileInputStream(file);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	try {
		prop.load(format);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return prop;
	
}

public void invokeBrowser(String browser)

{
	if(browser.equalsIgnoreCase("ie"))
		
	{
		System.setProperty("webdriver.ie.driver", "C:\\Users\\Basith\\Desktop\\Selenium Test\\Selenium\\lib\\IEDriverServer.exe");
		
		//capabilities.internetExplorer();
		
		/*capabilities.setCapability(
	            InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
	            true);*/

	        driver = new InternetExplorerDriver();
		
	
		
		
		
		
	}
	else if(browser.equalsIgnoreCase("chrome"))
	{
		
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Basith\\Desktop\\Selenium Test\\Selenium\\drivers\\chromedriver.exe");
		
	//capabilities.chrome();
	
	ChromeDriver chrome = new ChromeDriver();
		//capabilities.chrome();
	}
	
	else
	{
		FirefoxDriver firefox = new FirefoxDriver();
		
	}
	driver.manage().window().maximize();
	
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.MINUTES);

	}

public void openUrl(String url)
{
	driver.get(url);
	
}

public void clickByLinkText(String linkText)


{
	driver.findElement(By.linkText(linkText));
}


public void closeBrowser()
{
	driver.close();
}




	
	
}
	

