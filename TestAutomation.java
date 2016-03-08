package createSeleniumScript;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;


public class TestAutomation {
	public static WebDriver driver;
	
	private static final String URL="file:///C:/Users/soumyajitn/Desktop/Test%20WebPage.html";
	
	
	
	@SuppressWarnings("unchecked")
	public static void executeTestCase() throws InterruptedException{
		
		driver = new FirefoxDriver();
		
		//Implicit TimeOut
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//invoke the webpage to be tested
		driver.get(URL);
		
		//maximize the window
		driver.manage().window().maximize();
		
		//Check whether the correct WebPage is invoked
		if(driver.getCurrentUrl().equals(URL)){
			System.out.println("You have invoked the expected Webpage to test");
			System.out.println();
			System.out.println("Page Title :"+driver.getTitle());
		}
		
		Thread.sleep(2000);
		
		//Test First Name TextBox Field
		WebElement element = driver.findElement(By.id("fname"));
		
		if(element.isDisplayed()){
			System.out.println("TextBox FirstName : is present on Web Page");
			System.out.println();
			
				//Clear the content of Text Box First Name
				element.clear();
				System.out.println("The Content of TextBox First Name is cleared");
				System.out.println();
				//Enter the First Name
				element.sendKeys("Jennine");
			
		}
		
		Thread.sleep(2000);
		
		//Test LastName TextBox Field
		WebElement element1 = driver.findElement(By.id("lname"));
		
		if(element1.isDisplayed()){
			System.out.println("TextBox LastName : is present on Web Page");
			System.out.println();
			
			//Clear the content of Text Box Last Name
			element1.clear();
			System.out.println("The Content of TextBox Last Name is cleared");
			System.out.println();
			//Enter the Last Name
			element1.sendKeys("Lane");
		}	
		
		
		WebElement gender = driver.findElement(By.name("gender"));
		if(gender.isSelected()){
			System.out.println("Gender RadioButton is already Selected");
			
		}
		
		List<WebElement> radioButton = /*FunctionLibrary.createWebList(By locatorRadioButton,String nameRadioButton)*/driver.findElements(By.name("gender"));

	     for (int i = 0; i < radioButton.size(); i++) {
	       System.out.println("Selected:" + i + "/" + radioButton.get(i).isSelected());
	    }
      
	    radioButton.get(1).click();
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    Thread.sleep(2000);
	    
	    //Select Dropdown Month of Joining :
	    //Check if the drop down is enabled
	    if(driver.findElement(By.id("JoiningMonth")).isEnabled()){
	    	Select dropdown = new Select(driver.findElement(By.id("JoiningMonth")));
			dropdown.selectByVisibleText("February");	
	    }
	    
	    Thread.sleep(3000);
	    
	    //Verify whether the checkbox is selected
	    if(driver.findElement(By.name("vehicle")).isSelected()){
	    	System.out.println("Checkbox is already selected ");	
	    }
	    else{
	    	List<WebElement> checkBoxGroup = driver.findElements(By.name("vehicle"));

		     for (int i = 0; i < checkBoxGroup.size(); i++) {
		       System.out.println("Selected:" + i + "/" + checkBoxGroup.get(i).isSelected());
		    }
	       //Select a checkbox
		    checkBoxGroup.get(1).click();
		    System.out.println("checkbox is selected");
	    	
	    }
	    Thread.sleep(2000);
	    
	    //Check for the Technology the Employee has Worked
	    //Select Drop down Yes/No  :
	    //Check if the drop down is enabled
	    
	    	if(driver.findElement(By.id("workedOrNot1stDropDown")).isEnabled()){
		    	Select dropdown = new Select(driver.findElement(By.id("workedOrNot1stDropDown")));
				dropdown.selectByVisibleText("Yes");	
		    }	
	    
	    
	    	if(driver.findElement(By.id("workedOrNot2ndDropDown")).isEnabled()){
		    	Select dropdown = new Select(driver.findElement(By.id("workedOrNot2ndDropDown")));
				dropdown.selectByVisibleText("No");	
		    }	
	    
	    Thread.sleep(2000);
	    
	    //2nd set of checkboxes
	    
	    WebElement checkBox = driver.findElement(By.xpath("//label[text()='Seaside & Country Homes']/preceding-sibling::input[@type='checkbox']"));

	    checkBox.click();
      //Select a checkbox
	    
	    
	    //Click on Submit button
	    driver.findElement(By.xpath("//input[@value='Submit']")).click();
	    
	    Thread.sleep(2000);
	    
	    //Accept the alert
	    System.out.println(driver.switchTo().alert().getText());
	    driver.switchTo().alert().accept();
	    
	    //Check the page after the alert is checked
	    System.out.println(driver.getTitle());
	    
	    WebElement cheese = driver.findElement(By.cssSelector("#food span.dairy.aged"));
	    System.out.println(cheese.getText());
	    
	    //********************************************************************
	    List<WebElement> labels = driver.findElements(By.tagName("label"));
	    List<WebElement> inputs = (List<WebElement>) ((JavascriptExecutor)driver).executeScript("var labels = arguments[0], inputs = []; for (var i=0; i < labels.length; i++){" +
	        "inputs.push(document.getElementById(labels[i].getAttribute('for'))); } return inputs;", labels);
       
        //Dropdown**************************************************************************
        WebElement select = driver.findElement(By.tagName("select"));
        List<WebElement> allOptions = select.findElements(By.tagName("option"));
        for (WebElement option : allOptions) {
            System.out.println(String.format("Value is: %s", option.getAttribute("value")));
            option.click();
        }
        
        Thread.sleep(5000L);
        //******************************************************************************
        Select selectDropdown = new Select(select);
        //selectDropdown.deselectAll();
        selectDropdown.selectByVisibleText("August");
        
        //**************************************************************************
        /*Alternatively, WebDriver has the convenience method “submit” on every element.
        If you call this on an element within a form, WebDriver will walk up the DOM 
        until it finds the enclosing form and then calls submit on that. 
        If the element isn’t in a form, then the NoSuchElementException will be thrown:*/
        WebElement element2 = driver.findElement(By.id("number"));
        /*Exception in thread "main" 
        org.openqa.selenium.NoSuchElementException: 
        Element was not in a form so couldn't submit*/
        //element2.submit();
        
        driver.findElement(By.xpath("//a[contains(@href, 'somewhere.html')]")).click();
        
        System.out.println(driver.getWindowHandle());
        
        for (String handle : driver.getWindowHandles()) {
        	
            driver.switchTo().window(handle);
            System.out.println(driver.getWindowHandle());
        }
        
        
        
        
        
        
        
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			TestAutomation.executeTestCase();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error Messsage"+e.getMessage());
		}
		
	}

}
