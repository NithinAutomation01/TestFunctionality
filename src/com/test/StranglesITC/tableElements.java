package com.test.StranglesITC;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.test.DateFunction;

public class tableElements {
	private static String Chrome_driver_path = "C:\\Users\\user\\Downloads\\chromedriver.exe";
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",Chrome_driver_path);
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		String baseURL = "https://www.nseindia.com/live_market/dynaContent/live_watch/option_chain/optionKeys.jsp";
		driver.get(baseURL);
		DateFunction dt = new DateFunction();
		String date =dt.customized_time();
		driver.navigate().refresh();

		String Nifty_value=driver.findElement(By.xpath("//*[@id='wrapper_btm']/table[1]/tbody/tr/td[2]/div/span[1]/b")).getText();
	WebElement OCTable= driver.findElement(By.xpath("//table[@id='octable']/tbody"));

//	WebElement htmltable=driver.findElement(By.xpath("//*[@id='main']/table[1]/tbody"));
	
	List<WebElement> rows=OCTable.findElements(By.tagName("tr"));
	
	for(int rnum=1;rnum<rows.size();rnum++)
	{
	
		List<WebElement> columns=rows.get(rnum).findElements(By.tagName("td"));
		/*System.out.println("Number of rows:"+rnum+rows.get(rnum));
		System.out.println("Number of rows:"+rows.size());*/
		System.out.println(driver.findElement(By.xpath("//table[@id='octable']/tbody/tr["+rnum+"]/td[18]/a")).getText());
		/*
		for(int cnum=0;cnum<columns.size();cnum++)
		
		{//*[@id="octable"]/tbody/tr[6]/td[18]/a
		
			if(cnum==17)
				System.out.println(columns.get(cnum).findElement(By.tagName("a")).getText());
		
	}*/
		
		}

	}

}
