package com.zerodha;
import java.util.List;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class zerodha {


	private static String Chrome_driver_path = "C:\\Users\\user\\Downloads\\chromedriver.exe";
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",Chrome_driver_path);
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		String baseURL = "https://www.moneycontrol.com/stocks/marketstats/bse-gainer/sp-bse-finance_71/";
		driver.get(baseURL);
		driver.navigate().refresh();

		StringBuffer sb = new StringBuffer();
		StringBuffer sb1 = new StringBuffer();
		float temp =0;
		// to find the size of the rows we need to iterate thru webelement and use sizeof();
		for(int i = 1;i<15;i++)
		{

			String text =driver.findElement(By.xpath("//*[@id='mc_content']//table/tbody/tr["+i+"]/td[7]")).getText();
			float text_value= Float.parseFloat(text);
			float text_value1= Float.parseFloat(text);
			System.out.println(text_value);

			if(text_value>=3.0){
				System.out.println("inside"+i);
				String Script_name = driver.findElement(By.xpath("//*[@id='mc_content']//table/tbody/tr["+i+"]/td[1]")).getText();
				/*System.out.println(Script_name);

				sb.append(Script_name);*/
				
			}
			



		}
		System.out.println("The following scripts are trending with a velocity greater than 3%" +sb);
		


	}
}


