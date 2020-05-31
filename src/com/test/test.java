package com.test;

import java.sql.*;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.mysql.connections.MySqlConnections;

public class test {
	private static String Chrome_driver_path = "C:\\Users\\user\\Downloads\\chromedriver.exe";
	public static void main(String args[]) throws SQLException, Exception{  
		
		System.setProperty("webdriver.chrome.driver",Chrome_driver_path);
		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		String baseURL = "https://www.nseindia.com/";
		
		
		
		for(int i =1;i<4;i++){
			driver.get(baseURL);
		driver.findElement(By.id("keyword")).sendKeys("ITC");
		driver.findElement(By.id("keyword")).sendKeys(Keys.RETURN);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String Current_price1 = driver.findElement(By.xpath("//*[@id='lastPrice']")).getText();
		String Current_time = driver.findElement(By.xpath("//*[@id='LastUpdatedDiv']")).getText();
		
		
		//Connections establishments//
		MySqlConnections mycon = new MySqlConnections();
		Connection con = mycon.connections();
		// joda date functions //
		DateFunction dt = new DateFunction();
		String time =dt.customized_time();
		// inserting records into database//
		PreparedStatement stmt=con.prepareStatement("insert into itc values(?,?)");  
		stmt.setString(1,time);//1 specifies the first parameter in the query  
		stmt.setString(2,Current_price1);  
		System.out.println(time+":"+Current_price1);
		
		  
		int ik=stmt.executeUpdate();  
		System.out.println(ik+" records inserted");  
		  
		con.close();  
		  
		
		  
		Thread.sleep(20000);
		System.out.println("After loop :" +i);
		
		}
		
	}}