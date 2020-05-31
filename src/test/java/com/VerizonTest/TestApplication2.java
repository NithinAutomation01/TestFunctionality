package com.VerizonTest;

import static com.pdfunit.AbstractTest.PATH;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pdfunit.AssertThat;
import com.pdfunit.filter.page.AnyPage;
import com.pdfunit.filter.page.PagesToUse;
import com.pdfunit.validators.DocumentValidator;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.testng.ITestResult;
import org.testng.SkipException;

import de.redsix.pdfcompare.PdfComparator;

public class TestApplication2 {
	

	 static FileReader reader = null;
		static XSSFWorkbook workbook;
		static XSSFSheet sheet;
		static Scanner sc;
		static Properties p; 
		static FileInputStream ExcelFile= null;
static String purchase_receipt_BAU =Constants.purchase_receipt_BAU;
	static String purchase_receipt_NSA = "C:\\Users\\user\\Desktop\\Generated\\purchaseReceipt_PDF.pdf";
	
	
	@Test(description="Validating the default pages present in the BAU - PDF")
	public void PageValidation_BAU() throws Exception {
	AssertThat.document(purchase_receipt_BAU)
		.hasNumberOfPages(Constants.purchase_receipt_BAU_default_Pages)
		;}
		
	@Test(description="Validating the default pages present in the NAS - PDF")
		public void PageValidation_NSA() throws Exception {
			AssertThat.document(purchase_receipt_NSA)
			.hasNumberOfPages(Constants.purchase_receipt_NSA_default_Pages)
			;
		}
	@Test(description="visual comparison between the two pdfs")
	public void VisualImageComparison(){
		String file1 = purchase_receipt_BAU;
		String file2 = purchase_receipt_NSA;
		String resultFile =Constants.resultFile;

		
try {
	new PdfComparator(file1,file2).compare().writeTo(resultFile);
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

System.out.println("Image comparison completed and written to the filepath");


	}

	@Test(description = "Validates the default fonts present in the Schema Page for the BAU pdf")
	public void fontType_BAU() throws Exception {
	String filename = Constants.purchase_receipt_BAU;
	AssertThat.document(filename)
	.hasFont().withNameContaining("Helvetica");
	
	
	
	}
	
	
	@Test(description = "Validates the default fonts present in the Schema Page for the NAS pdf")
	public void fontType_NAS() throws Exception {
	String filename = Constants.purchase_receipt_NSA;
	AssertThat.document(filename)
	.hasFont().withNameContaining("Helvetica")
	;
	}
	@Test(description = "Validates the negative scenario for either of the PDF schema")
	public void fontType_NegativeScenario() throws Exception {
	String filename = Constants.purchase_receipt_NSA;
	AssertThat.document(filename)
	.hasFont().withNameContaining("Arial")
	;
	}
	@Test(description = "Validates the textual Characters present in the 1st Page of The BAU")
	public void BAU_FirstPageTextualValidations() throws Exception {
	String filename = Constants.purchase_receipt_BAU;
	ExcelFile = new FileInputStream(Constants.SchemaValidations_Workbook);
	workbook = new XSSFWorkbook(ExcelFile);
	sheet = workbook.getSheetAt(0);
		for(int i =1;i<4;i++){
		String tempval = sheet.getRow(i).getCell(0).getStringCellValue();
		System.out.println(tempval);
	    AssertThat.document(filename)
	     .restrictedTo(PagesToUse.getPage(1))
	  
	      .hasText()
	      .containing(tempval);
	    		tempval ="";
	       }
	 }
	@Test(description = "Validates the textual Characters present in the 2nd Page of The BAU")
	public void BAU_SecondPageTextualValidations() throws Exception {
	String filename = Constants.purchase_receipt_BAU;
	ExcelFile = new FileInputStream(Constants.SchemaValidations_Workbook);
	workbook = new XSSFWorkbook(ExcelFile);
	sheet = workbook.getSheetAt(0);
	for(int i =1;i<4;i++){
		String tempval = sheet.getRow(i).getCell(1).getStringCellValue();
		System.out.println(tempval);
	    AssertThat.document(filename)
	     .restrictedTo(PagesToUse.getPage(2))
	    
	      .hasText()
	      .containing(tempval);
	    		tempval ="";
	       }
	 }
	@Test(description = "Validates the textual Characters present in the 3rd Page of The BAU")
	public void BAU_ThirdPageTextualValidations() throws Exception {
	String filename = Constants.purchase_receipt_BAU;
	ExcelFile = new FileInputStream(Constants.SchemaValidations_Workbook);
	workbook = new XSSFWorkbook(ExcelFile);
	for(int i =1;i<4;i++){
		String tempval = sheet.getRow(i).getCell(2).getStringCellValue();
		System.out.println(tempval);
	    AssertThat.document(filename)
	     .restrictedTo(PagesToUse.getPage(3))
	 
	      .hasText()
	      .containing(tempval);
	    		tempval ="";
	       }
	 }
	@Test(description = "Validates the textual Characters present in the 1st Page of The NSA")
	public void NSA_FirstPageTextualValidations() throws Exception {
	String filename = Constants.purchase_receipt_NSA;
	ExcelFile = new FileInputStream(Constants.SchemaValidations_Workbook);
	workbook = new XSSFWorkbook(ExcelFile);
	sheet = workbook.getSheetAt(0);
		for(int i =1;i<4;i++){
		String tempval = sheet.getRow(i).getCell(3).getStringCellValue();
		System.out.println(tempval);
	    AssertThat.document(filename)
	     .restrictedTo(PagesToUse.getPage(1))
	  
	      .hasText()
	      .containing(tempval);
	    		tempval ="";
	       }
	 }
	@Test(description = "Validates the textual Characters present in the 2nd Page of The NSA")
	public void NSA_SecondPageTextualValidations() throws Exception {
	String filename = Constants.purchase_receipt_NSA;
	ExcelFile = new FileInputStream(Constants.SchemaValidations_Workbook);
	workbook = new XSSFWorkbook(ExcelFile);
	sheet = workbook.getSheetAt(0);
	for(int i =1;i<4;i++){
		String tempval = sheet.getRow(i).getCell(4).getStringCellValue();
		System.out.println(tempval);
	    AssertThat.document(filename)
	     .restrictedTo(PagesToUse.getPage(2))
	    
	      .hasText()
	      .containing(tempval);
	    		tempval ="";
	       }
	 }
	@Test(description = "Validates the textual Characters present in the 3rd Page of The NSA")
	public void NSA_ThirdPageTextualValidations() throws Exception {
		String filename = Constants.purchase_receipt_NSA;
	ExcelFile = new FileInputStream(Constants.SchemaValidations_Workbook);
	workbook = new XSSFWorkbook(ExcelFile);
	for(int i =1;i<4;i++){
		String tempval = sheet.getRow(i).getCell(5).getStringCellValue();
		System.out.println(tempval);
	    AssertThat.document(filename)
	     .restrictedTo(PagesToUse.getPage(3))
	 
	      .hasText()
	      .containing(tempval);
	    		tempval ="";
	       }
	 }
	
	@Test(description = "validating verizon logo with the NSA pdf-- 1st page")
	public void ImageComparison_FirstPage_BAU() throws Exception {
	  String filename = Constants.purchase_receipt_NSA;

	    String imageFile = Constants.verizon_Logo;
	 
	    AssertThat.document(filename)
	      .restrictedTo(PagesToUse.getPage(1))
	      .hasImage()
	      .matching(imageFile);
	}
	@Test(description = "validating verizon logo(present in 1st page) with the NSA pdf-- 3rd page")
	public void ImageComparison_ThirdPage_BAU() throws Exception {
	  String filename = Constants.purchase_receipt_NSA;

	    String imageFile = Constants.verizon_Logo;
	 
	    AssertThat.document(filename)
	      .restrictedTo(PagesToUse.getPage(3))
	      .hasImage()
	      .matching(imageFile);
	}
	
	@Test(description = "Random Image Comparison")
	public void RandomImageComparison() throws Exception {
	  String filename = Constants.purchase_receipt_BAU;

	    String imageFile = Constants.unmatched_Logo;
	 
	    AssertThat.document(filename)
	      .restrictedTo(AnyPage.getInstance())
	      .hasImage()
	      .matching(imageFile);
	}
}

