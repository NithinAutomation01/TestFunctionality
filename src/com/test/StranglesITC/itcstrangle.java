package com.test.StranglesITC;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.mysql.connections.MySqlConnections;
import com.test.DateFunction;

public class itcstrangle {
	private static String Chrome_driver_path = "C:\\Users\\user\\Downloads\\chromedriver.exe";

	public static void main(String[] args) throws Exception {

		System.setProperty("webdriver.chrome.driver",Chrome_driver_path);
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		String baseURL = "https://www.nseindia.com/live_market/dynaContent/live_watch/option_chain/optionKeys.jsp";
		for(int i = 1;i<200;i++){
			DateFunction dt = new DateFunction();
			String date =dt.customized_time();
			
			
			
		driver.get(baseURL);
		driver.navigate().refresh();

		String Nifty_value=driver.findElement(By.xpath("//*[@id='wrapper_btm']/table[1]/tbody/tr/td[2]/div/span[1]/b")).getText();
		//put values
		String Nifty_9700_pe = driver.findElement(By.xpath("//*[@id='octable']/tbody/tr[24]/td[18]/a")).getText();
		float Nifty_9700_pe_float = Float.valueOf(Nifty_9700_pe);
		String Nifty_9800_pe = driver.findElement(By.xpath("//*[@id='octable']/tbody/tr[26]/td[18]/a")).getText();
		float Nifty_9800_pe_float = Float.valueOf(Nifty_9800_pe);
		String Nifty_9900_pe = driver.findElement(By.xpath("//*[@id='octable']/tbody/tr[28]/td[18]/a")).getText();
		float Nifty_9900_pe_float = Float.valueOf(Nifty_9900_pe);
		String Nifty_10000_pe = driver.findElement(By.xpath("//*[@id='octable']/tbody/tr[30]/td[18]/a")).getText();
		float Nifty_10000_pe_float = Float.valueOf(Nifty_10000_pe);
		String Nifty_10100_pe = driver.findElement(By.xpath("//*[@id='octable']/tbody/tr[32]/td[18]/a")).getText();
		float Nifty_10100_pe_float = Float.valueOf(Nifty_10100_pe);
		String Nifty_10200_pe = driver.findElement(By.xpath("//*[@id='octable']/tbody/tr[34]/td[18]/a")).getText();
		float Nifty_10200_pe_float = Float.valueOf(Nifty_10200_pe);
		String Nifty_10300_pe = driver.findElement(By.xpath("//*[@id='octable']/tbody/tr[36]/td[18]/a")).getText();
		float Nifty_10300_pe_float = Float.valueOf(Nifty_10300_pe);
		String Nifty_10400_pe = driver.findElement(By.xpath("//*[@id='octable']/tbody/tr[38]/td[18]/a")).getText();
		float Nifty_10400_pe_float = Float.valueOf(Nifty_10400_pe);
		String Nifty_10500_pe = driver.findElement(By.xpath("//*[@id='octable']/tbody/tr[40]/td[18]/a")).getText();
		float Nifty_10500_pe_float = Float.valueOf(Nifty_10500_pe);
		//call values
		String Nifty_10400_ce = driver.findElement(By.xpath("//*[@id='octable']/tbody/tr[38]/td[6]/a")).getText();
		float Nifty_10400_ce_float = Float.valueOf(Nifty_10400_ce);
		String Nifty_10500_ce = driver.findElement(By.xpath("//*[@id='octable']/tbody/tr[40]/td[6]/a")).getText();
		float Nifty_10500_ce_float = Float.valueOf(Nifty_10500_ce);
		String Nifty_10600_ce = driver.findElement(By.xpath("//*[@id='octable']/tbody/tr[42]/td[6]/a")).getText();
		float Nifty_10600_ce_float = Float.valueOf(Nifty_10600_ce);
		String Nifty_10700_ce = driver.findElement(By.xpath("//*[@id='octable']/tbody/tr[44]/td[6]/a")).getText();
		float Nifty_10700_ce_float = Float.valueOf(Nifty_10700_ce);
		String Nifty_10800_ce = driver.findElement(By.xpath("//*[@id='octable']/tbody/tr[46]/td[6]/a")).getText();
		float Nifty_10800_ce_float = Float.valueOf(Nifty_10800_ce);
		String Nifty_10900_ce = driver.findElement(By.xpath("//*[@id='octable']/tbody/tr[48]/td[6]/a")).getText();
		float Nifty_10900_ce_float = Float.valueOf(Nifty_10900_ce);
		String Nifty_11000_ce = driver.findElement(By.xpath("//*[@id='octable']/tbody/tr[50]/td[6]/a")).getText();
		float Nifty_11000_ce_float = Float.valueOf(Nifty_11000_ce);
		String Nifty_11100_ce = driver.findElement(By.xpath("//*[@id='octable']/tbody/tr[52]/td[6]/a")).getText();
		float Nifty_11100_ce_float = Float.valueOf(Nifty_11100_ce);
		
		
		/*float Strangle_10100_10700 =  Nifty_10100_pe_float+Nifty_10700_ce_float;
		float Strangle_10000_10800 =  (Nifty_10000_pe_float+Nifty_10800_ce_float);
		float Strangle_9900_10900 =  (Nifty_9900_pe_float+Nifty_10900_ce_float);
		float Strangle_9800_11000 = (Nifty_9800_pe_float+Nifty_11000_ce_float);
		System.out.println("The strangle cost of 10100_10700:"+Strangle_10100_10700);
		System.out.println("The strangle cost of 10000_10800:" +Strangle_10000_10800);
		System.out.println("The strangle cost of 9900_10900:"+Strangle_9900_10900);
		System.out.println("The strangle cost of 9800_11000:"+Strangle_9800_11000);*/
		
		//Debit spreads updside curve
		float debit_spread_10600_10700_ce = Nifty_10600_ce_float-Nifty_10700_ce_float;
		float debit_spread_10700_10800_ce = Nifty_10700_ce_float-Nifty_10800_ce_float;
		float debit_spread_10800_10900_ce = Nifty_10800_ce_float-Nifty_10900_ce_float;
		float debit_spread_10900_11000_ce = Nifty_10900_ce_float-Nifty_11000_ce_float;
		float debit_spread_11000_11100_ce = Nifty_11000_ce_float-Nifty_11100_ce_float;
		//Debit spread downside put curve
		
		float debit_spread_9700_9800_pe = Nifty_9800_pe_float-Nifty_9700_pe_float;
		float debit_spread_9900_9800_pe = Nifty_9900_pe_float-Nifty_9800_pe_float;
		float debit_spread_10000_9900_pe = Nifty_10000_pe_float-Nifty_9900_pe_float;
		float debit_spread_10100_10000_pe = Nifty_10100_pe_float-Nifty_10000_pe_float;
		float debit_spread_10200_10100_pe = Nifty_10200_pe_float-Nifty_10100_pe_float;
		float debit_spread_10300_10200_pe = Nifty_10300_pe_float-Nifty_10200_pe_float;
		float debit_spread_10400_10300_pe = Nifty_10400_pe_float-Nifty_10300_pe_float;
		float debit_spread_10500_10400_pe = Nifty_10500_pe_float-Nifty_10400_pe_float;
		
		
		
		MySqlConnections mysql= new MySqlConnections();
		Connection con =mysql.connections();
		PreparedStatement stmt=con.prepareStatement("insert into nifty_debit_spread_callside values(?,?,?,?,?,?,?)");  
		stmt.setString(1,date);//1 specifies the first parameter in the query  
		stmt.setString(2,Nifty_value);  
		stmt.setFloat(3,debit_spread_10600_10700_ce);
		stmt.setFloat(4,debit_spread_10700_10800_ce);
		stmt.setFloat(5,debit_spread_10800_10900_ce);
		stmt.setFloat(6,debit_spread_10900_11000_ce);
		stmt.setFloat(7,debit_spread_11000_11100_ce);
		PreparedStatement stmt1=con.prepareStatement("insert into nifty_debit_spread_putside values(?,?,?,?,?,?,?,?,?,?)");  

		stmt1.setString(1,date);//1 specifies the first parameter in the query  
		stmt1.setString(2,Nifty_value);  
		stmt1.setFloat(3,debit_spread_10500_10400_pe);
		stmt1.setFloat(4,debit_spread_10400_10300_pe);
		stmt1.setFloat(5,debit_spread_10300_10200_pe);
		stmt1.setFloat(6,debit_spread_10200_10100_pe);
		stmt1.setFloat(7,debit_spread_10100_10000_pe);
		stmt1.setFloat(8,debit_spread_10000_9900_pe);
		stmt1.setFloat(9,debit_spread_9900_9800_pe);
		stmt1.setFloat(10,debit_spread_9700_9800_pe);
		  
		int ik=stmt.executeUpdate();  
		System.out.println(ik+" records inserted in the bull spread database");  
		int ikk=stmt1.executeUpdate();  
		System.out.println(ikk+" records inserted in the bear spread database");  
		  
		con.close();  
		 
		
		  
		Thread.sleep(60000);
	
			
		
		}
		
	}

}
