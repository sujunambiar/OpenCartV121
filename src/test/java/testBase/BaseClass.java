package testBase;

import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.security.SecureRandom;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.ResourceBundle;
import java.net.URL;

public class BaseClass {

	public static WebDriver driver;
	public Logger logger;
	public Properties p;

	private static final SecureRandom random = new SecureRandom();
	String alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	String numbers = "1234567890";
	String alphaNumeric = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";

	@BeforeClass(groups = { "Sanity", "Regression", "Master" })
	@Parameters({ "os", "browser" })

	public void setUp(String os, String br) throws IOException

	{
		// Loading config.properties

		FileReader file = new FileReader("./src//test//resources//config.properties");

		p = new Properties();
		p.load(file);

		logger = LogManager.getLogger(this.getClass());

		if (p.getProperty("execution_env").equalsIgnoreCase("remote")) {

			DesiredCapabilities capabilities = new DesiredCapabilities();

			// os

			if (os.equalsIgnoreCase("windows")) {
				capabilities.setPlatform(Platform.WIN11);
			} else if (os.equalsIgnoreCase("mac")) {
				capabilities.setPlatform(Platform.WIN11);

			}

			else {
				System.out.println("No matching os");
				return;

			}
			// browser

			switch (br.toLowerCase()) {
			case "chrome":
				capabilities.setBrowserName("chrome");
				break;
			case "edge":
				capabilities.setBrowserName("MicrosoftEdge");
				break;
			default:
				System.out.println("No matching browser");
				return;

			}
			driver = new RemoteWebDriver(new URL(" http://192.168.2.200:4444/wd/hub"), capabilities);
		}
			if (p.getProperty("execution_env").equalsIgnoreCase("local")) {

				switch (br.toLowerCase())

				{
				case "chrome":
					driver = new ChromeDriver();
					break;
				case "edge":
					driver = new EdgeDriver();
					break;
				case "firefox":
					driver = new FirefoxDriver();
					break;
				default:
					System.out.println("Invalid browser name");
					return;
				}

			}

			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get(p.getProperty("appURL"));
			driver.manage().window().maximize();
		}
	

	@AfterClass(groups = { "Sanity", "Regression", "Master" })
	public void tearDown()

	{
		driver.close();

	}

	public String randomStringGenerator(int length)

	{

		StringBuilder sb = new StringBuilder(length);
		for (int i = 0; i < length; i++) {

			sb.append(alphabets.charAt(random.nextInt(alphabets.length())));

		}
		return sb.toString();
	}

	public String randomNumberGenerator(int length)

	{

		StringBuilder sb = new StringBuilder(length);
		for (int i = 0; i < length; i++) {

			sb.append(numbers.charAt(random.nextInt(numbers.length())));

		}
		return sb.toString();
	}

	public String randomalphaNumericGenerator(int length)

	{

		StringBuilder sb = new StringBuilder(length);
		for (int i = 0; i < length; i++) {

			sb.append(alphaNumeric.charAt(random.nextInt(alphaNumeric.length())));

		}
		return sb.toString();
	}

	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		return destination;

	}
}
