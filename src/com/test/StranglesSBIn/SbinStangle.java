package com.test.StranglesSBIn;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.mysql.connections.MySqlConnections;
import com.test.DateFunction;

public class SbinStangle {

	private static String Chrome_driver_path = "C:\\Users\\user\\Downloads\\chromedriver.exe";

	public static void main(String[] args) throws Exception {

		System.setProperty("webdriver.chrome.driver",Chrome_driver_path);
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		String baseURL = "https://www.nseindia.com/live_market/dynaContent/live_watch/option_chain/optionKeys.jsp?symbolCode=238&symbol=SBIN&symbol=SBIN&instrument=-&date=-&segmentLink=17&symbolCount=2&segmentLink=17";
		for(int i = 1;i<100;i++){
			driver.get(baseURL);
			driver.navigate().refresh();



			String SBI_value=driver.findElement(By.xpath("//*[@id='wrapper_btm']/table[1]/tbody/tr/td[2]/div/span[1]/b")).getText();
			System.out.println(SBI_value);

			//put values
			String SBIN_250_pe = driver.findElement(By.xpath("//*[@id='octable']/tbody/tr[11]/td[18]/a")).getText();
			float SBIN_250_pe_float = Float.valueOf(SBIN_250_pe);
			String SBIN_255_pe = driver.findElement(By.xpath("//*[@id='octable']/tbody/tr[12]/td[18]/a")).getText();
			float SBIN_255_pe_float = Float.valueOf(SBIN_255_pe);
			String SBIN_260_pe = driver.findElement(By.xpath("//*[@id='octable']/tbody/tr[13]/td[18]/a")).getText();
			float SBIN_260_pe_float = Float.valueOf(SBIN_260_pe);
			String SBIN_265_pe = driver.findElement(By.xpath("//*[@id='octable']/tbody/tr[14]/td[18]/a")).getText();
			float SBIN_265_pe_float = Float.valueOf(SBIN_265_pe);
			String SBIN_270_pe = driver.findElement(By.xpath("//*[@id='octable']/tbody/tr[15]/td[18]/a")).getText();
			float SBIN_270_pe_float = Float.valueOf(SBIN_270_pe);
			String SBIN_275_pe = driver.findElement(By.xpath("//*[@id='octable']/tbody/tr[16]/td[18]/a")).getText();
			float SBIN_275_pe_float = Float.valueOf(SBIN_275_pe);
			// call values
			String SBIN_295_ce = driver.findElement(By.xpath("//*[@id='octable']/tbody/tr[20]/td[6]/a")).getText();
			float SBIN_295_ce_float = Float.valueOf(SBIN_295_ce);
			String SBIN_300_ce = driver.findElement(By.xpath("//*[@id='octable']/tbody/tr[21]/td[6]/a")).getText();
			float SBIN_300_ce_float = Float.valueOf(SBIN_300_ce);
			String SBIN_305_ce = driver.findElement(By.xpath("//*[@id='octable']/tbody/tr[22]/td[6]/a")).getText();
			float SBIN_305_ce_float = Float.valueOf(SBIN_305_ce);

			String SBIN_310_ce = driver.findElement(By.xpath("//*[@id='octable']/tbody/tr[23]/td[6]/a")).getText();
			float SBIN_310_ce_float = Float.valueOf(SBIN_310_ce);
			String SBIN_315_ce = driver.findElement(By.xpath("//*[@id='octable']/tbody/tr[24]/td[6]/a")).getText();
			float SBIN_315_ce_float = Float.valueOf(SBIN_315_ce);
			String SBIN_320_ce = driver.findElement(By.xpath("//*[@id='octable']/tbody/tr[25]/td[6]/a")).getText();
			float SBIN_320_ce_float = Float.valueOf(SBIN_320_ce);

			// Strangle values
			float Stangle_275_295 = SBIN_295_ce_float+SBIN_275_pe_float;
			float Stangle_270_300 = SBIN_300_ce_float+SBIN_270_pe_float;
			float Stangle_265_305 = SBIN_305_ce_float+SBIN_265_pe_float;
			float Stangle_260_310 = SBIN_310_ce_float+SBIN_260_pe_float;
			float Stangle_255_315 = SBIN_315_ce_float+SBIN_255_pe_float;
			float Stangle_250_320 = SBIN_320_ce_float+SBIN_250_pe_float;


			/*	System.out.println(SBIN_250_pe_float);
			System.out.println(SBIN_255_pe_float);
			System.out.println(SBIN_260_pe_float);
			System.out.println(SBIN_265_pe_float);
			System.out.println(SBIN_270_pe_float);
			System.out.println(SBIN_275_pe_float);
			System.out.println("---------------------------");
			System.out.println(SBIN_295_ce_float);
			System.out.println(SBIN_300_ce_float);

			System.out.println(SBIN_305_ce_float);

			System.out.println(SBIN_310_ce_float);
			System.out.println(SBIN_315_ce_float);
			System.out.println(SBIN_320_ce_float);*/




			DateFunction dt = new DateFunction();
			String date =dt.customized_time();
			MySqlConnections mysql= new MySqlConnections();
			Connection con =mysql.connections();
			PreparedStatement stmt=con.prepareStatement("insert into sbin values(?,?,?,?,?,?,?,?)");  
			stmt.setString(1,date);//1 specifies the first parameter in the query  
			stmt.setString(2,SBI_value);  
			stmt.setFloat(3,Stangle_275_295);
			stmt.setFloat(4,Stangle_270_300);
			stmt.setFloat(5,Stangle_265_305);
			stmt.setFloat(6,Stangle_260_310);
			stmt.setFloat(7,Stangle_255_315);
			stmt.setFloat(8,Stangle_250_320);



			int ik=stmt.executeUpdate();  
			System.out.println(ik+" records inserted");  

			con.close();  



			Thread.sleep(60000);
			driver.manage().deleteAllCookies();


		}
	}



}
