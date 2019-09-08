package pages;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObjects {
	
	WebDriver driver;
	String driverPath = "C:\\Users\\User 1\\Dev\\Software\\Selenium\\chromedriver.exe";
	
	//URLS
	String googleUrl = "https://www.google.co.uk/";
	String truNarrativeUrl = "https://www.trunarrative.com/";
	
	WebDriverWait wait;
	//Google Page Objects
	By searchField = By.name("q");
	By firstLink = By.xpath("/html//div[@id='rso']/div[1]/div[@class='g']/div/div//a[@href='https://trunarrative.com/']");
	
	//TruNarrative Home Objects
	By strapline = By.className("bigger");
	By moreLink = By.id("menu-item-6055");
	By teamLink = By.id("menu-item-6388");
	
	//TruNarrative Team Page Objects
	By teamImages = By.className("stack-img-content");
	By johnLord = By.xpath("//*[@id=\"main-content-wrapper\"]/section[2]/div/article/div/div[1]/div[2]/div");
	By davidEastaugh = By.xpath("//*[@id=\"main-content-wrapper\"]/section[2]/div/article/div/div[5]/div[2]/div");
	By nicolaJanney = By.xpath("//*[@id=\"main-content-wrapper\"]/section[2]/div/article/div/div[8]/div[2]/div");
	By johnTitle = By.cssSelector("article .stack-img-content:nth-of-type(1) .sub");
	By davidTitle = By.cssSelector("article .stack-img-content:nth-of-type(5) .sub");
	By nicolaTitle = By.cssSelector("article .stack-img-content:nth-of-type(8) .sub");
		
	public PageObjects(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void chromeDriver()
	{
	System.setProperty("webdriver.chrome.driver", driverPath);
	driver = new ChromeDriver();
	wait = new WebDriverWait(driver, 50);
	driver.manage().window().maximize();
	}
	
	public void closeBrowser()
	{
			driver.close();
	}
	
	public void getGoogle()
	{
		driver.get(googleUrl);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertEquals("Google", driver.getTitle());	
	}
	
	public void getTruNarrative()
	{
		driver.get(truNarrativeUrl);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public void waitForFirstLink()
	{
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(firstLink)));
	}
	
	public void pointsToTnHome()
	{
		WebElement home = driver.findElement(firstLink);
		Assert.assertEquals(home.getAttribute("href"), "https://trunarrative.com/");
	}
	
	public void searchTruNarrative()
	{
		driver.findElement(searchField).sendKeys("TruNarrative" + Keys.ENTER);
	}
	
	public void checkHomeTitle() throws Exception
	{
        String truNarrativeTitle = driver.getTitle();
        // Home page title is null
        if("".equals(truNarrativeTitle)){
           System.out.println("When: TruNarrative home page is displayed - Success" );
        }
        else{
        	throw new Exception("When: TruNarrative home page is displayed - Failed");
        }
	}
	
	public void findStrapline()
	{
		Assert.assertEquals(driver.findElement(strapline).getText(), "Easy Onboarding.  Smooth Transactions.  Insightful Compliance.");
	}
	
	public void goToTeamPage() throws Exception
	{
		driver.get("https://www.trunarrative.com/");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(moreLink)));
		driver.findElement(moreLink).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(teamLink)));
		driver.findElement(teamLink).click();
        String teamPageTitle = driver.getTitle();
        if("TruNarrative Team".equals(teamPageTitle)){
           System.out.println("When: User has navigated to Team Page - Success" );
        }
        else{
        	throw new Exception("When: User has navigated to Team Page - Failed");
        }
	}
	
	public void findTeamMembers()
	{
		driver.findElements(teamImages).size();
	}
	
	public void countTeamMembers()
	{
		int teamCount = driver.findElements(teamImages).size();
		Assert.assertTrue(teamCount == 8);
	}
	
	public void findJohnLord()
	{
		driver.findElement(johnLord);
	}
	
	public void findDavidEastaugh()
	{
		driver.findElement(davidEastaugh);
	}
	
	public void findNicolaJanney()
	{
		driver.findElement(nicolaJanney);
	}
	
	public void hasRoleFounder() throws Exception
	{
		 String johnJobTitle = driver.findElement(johnTitle).getText();
	       if("Founder & CEO".equals(johnJobTitle)) {
	           System.out.println("Then: he has role Founder and CEO - Success" );
	        }
	        else{
	            throw new Exception("Then: he has role Founder and CEO - Failed");
	        }
	}
	
	public void hasRoleCto() throws Exception
	{
		String davidJobTitle = driver.findElement(davidTitle).getText();
		 if("Chief Technology Officer".equals(davidJobTitle)) {
	           System.out.println("Then: he has role CTO - Success" );
	        }
	        else{
	            throw new Exception("Then: he has role CTO - Failed");
	        }	
	}
	
	public void hasRoleHr() throws Exception
	{
		String nicolaJobTitle = driver.findElement(nicolaTitle).getText();
		 if("Human Resources Manager".equals(nicolaJobTitle)) {
	           System.out.println("Then: she has role Human Resources Manager - Success" );
	        }
	        else{
	            throw new Exception("Then: she has role Human Resources Manager - Failed");
	        }
	}
}
